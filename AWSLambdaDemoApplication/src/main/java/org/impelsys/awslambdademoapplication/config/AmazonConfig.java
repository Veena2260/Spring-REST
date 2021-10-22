package org.impelsys.awslambdademoapplication.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class AmazonConfig {
	
	@Value("${aws.accessKey}")
	String accessKey;
	
	@Value("${aws.secretKey}")
	String secretKey;
	
	@Value("${cloud.aws.region.static}")
	String region;
	 
	AWSCredentials awsCredentials;
	AmazonS3 s3;
	/*@PostConstruct
	public void postConstruct() {
		awsCredentials=new BasicAWSCredentials(accessKey,secretKey);
	}*/
	@Bean
	public AmazonSNS amazonSNS() {
		
		return AmazonSNSClientBuilder.standard()
				.withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials())).build();
	}
	
	@Bean
	   public AWSCredentials awsCredentials(){
	      return new BasicAWSCredentials(accessKey, secretKey);
	   }
	
	public AmazonConfig() {
		System.out.println("in Constructor");
	}
	
	@Bean("s3_1")
	public AmazonS3 s3_1() {
		 AWSCredentials awsCredentials=new BasicAWSCredentials(accessKey,
				secretKey);
		System.out.println("AccessKey" + accessKey);
		System.out.println("secretKey"+ secretKey);
		System.out.println("Region" + region);
		s3= AmazonS3ClientBuilder
				.standard()
				.withRegion("ap_south_1")
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
		return s3;
				
		
	}
	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials=new BasicAWSCredentials(accessKey,
				secretKey);
		System.out.println("AccessKey" + accessKey);
		System.out.println("secretKey"+ secretKey);
		System.out.println("Region" + region);
		s3= AmazonS3ClientBuilder
				.standard()
				.withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
		return s3;
	}
	@Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory() {
        SimpleMessageListenerContainerFactory msgListenerContainerFactory = new SimpleMessageListenerContainerFactory();
        msgListenerContainerFactory.setAmazonSqs(amazonSQSAsync());
        return msgListenerContainerFactory;
    }
    public AmazonSQSAsync amazonSQSAsync(){
        return AmazonSQSAsyncClientBuilder.standard().withRegion(region)   
            .withCredentials(new AWSStaticCredentialsProvider(awsCredentials())).build();
    }
   
    @Bean
    public QueueMessageHandler queueMessageHandler() {
        QueueMessageHandlerFactory queueMsgHandlerFactory = new QueueMessageHandlerFactory();
        queueMsgHandlerFactory.setAmazonSqs(amazonSQSAsync());
        QueueMessageHandler queueMessageHandler = queueMsgHandlerFactory.createQueueMessageHandler();
        List<HandlerMethodArgumentResolver> list = new ArrayList<>();
        HandlerMethodArgumentResolver resolver = new PayloadArgumentResolver(new MappingJackson2MessageConverter());
        list.add(resolver);
        queueMessageHandler.setArgumentResolvers(list);
        return queueMessageHandler;
    }
   
    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(){
       
        return new QueueMessagingTemplate(amazonSQSAsync());
    }
	
	}
	
	



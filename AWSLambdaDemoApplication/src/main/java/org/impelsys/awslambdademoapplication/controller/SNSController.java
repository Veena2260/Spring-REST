package org.impelsys.awslambdademoapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
@RequestMapping("/sms")
public class SNSController {
	
	
	
	@Autowired
	AmazonSNS amazonSNSClient;
	String TOPIC_ARN="arn:aws:sns:us-east-2:517430737178:MyTopic";
	@PostMapping("/subscribe/{mobileno}")
	public ResponseEntity<String> addSubscription(@PathVariable String mobileno){
		System.out.println("Adding Mobile no  "+ mobileno + "to subscriber list" );
		SubscribeRequest  request=new SubscribeRequest(TOPIC_ARN,"sms",mobileno);
		
		amazonSNSClient.subscribe(request);
		return new ResponseEntity<>("Mobile number added to subscriptionlist",HttpStatus.OK);
	}

	@PostMapping("/publish/{message}")
	public ResponseEntity<String> publishMessageToTopic(@PathVariable String message) {
		
		int requestTimeout=4000;
		/*
		 * Map<String,MessageAttributeValue> smsAttributes=new
		 * HashMap<String,MessageAttributeValue>();
		 * smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
		 * .withDataType("String") .withStringValue("Transactional")); //PublishRequest
		 * request=PublishRequest.builder()
		 * 
		 * PublishResult result=amazonSNSClient.publish(new PublishRequest()
		 * .withMessage(message) .withPhoneNumber(mobileno)
		 * .withMessageAttributes(smsAttributes));
		 * //.withSdkRequestTimeout(requestTimeout)); System.out.println("result: "
		 * +result.getMessageId());
		 */
		
		
		PublishRequest publishRequest=new PublishRequest(TOPIC_ARN,message);
		amazonSNSClient.publish(publishRequest);
		return new ResponseEntity<>("Notification Sent Successfully!!!",HttpStatus.OK); 
		
	}
	

}

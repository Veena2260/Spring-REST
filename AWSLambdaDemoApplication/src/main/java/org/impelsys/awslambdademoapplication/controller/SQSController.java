package org.impelsys.awslambdademoapplication.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@RestController
@RequestMapping("/sqs")
public class SQSController {
	
	@Autowired
	QueueMessagingTemplate queueMessagingTemplate;
	
	@Value("${cloud.aws.end-point}")
	String queueEndPoint;
	
	@PostMapping(value="/{message}")
	public String postMessage(@PathVariable String message) {
		
		Map<String,Object> headers=new HashMap<String,Object>();
		headers.put("message-group-id","group-id-1");
		headers.put("message-deduplication-id", "deduplication-id-1");
		queueMessagingTemplate.convertAndSend(queueEndPoint, message,headers);
		return "Message posted to SQS!";
		
	}
	
	@SqsListener(value="MyQueue.fifo",deletionPolicy=SqsMessageDeletionPolicy.NEVER)
	public void processMessage(String message,Acknowledgment acknowledgement) {
		System.out.println("Processing Message " + message+" "+acknowledgement.acknowledge().isDone());
		try {
			DeleteMessageResult future=(DeleteMessageResult) acknowledgement.acknowledge().get();
			System.out.println(future.getSdkResponseMetadata().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

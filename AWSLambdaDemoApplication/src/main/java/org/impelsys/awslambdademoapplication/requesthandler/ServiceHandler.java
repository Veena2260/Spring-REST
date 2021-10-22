package org.impelsys.awslambdademoapplication.requesthandler;

import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ServiceHandler  implements RequestHandler<Map<String,String>,Object> {
	
		@Override
		public String handleRequest(Map<String,String> input, Context context) {
			context.getLogger().log("input is "+ input);
			//s3
			return "Hello World" + input;
		}
}

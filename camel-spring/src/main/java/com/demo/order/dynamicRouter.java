package com.demo.order;

import org.apache.camel.Exchange;
import org.apache.camel.model.DynamicRouterDefinition;

public class dynamicRouter extends DynamicRouterDefinition {


	public String route(Exchange exchange){
		System.out.println("Inside the dynamic route");
		Input input=exchange.getIn().getBody(Input.class);
		String id = input.getOrderNum();
		exchange.getOut().setBody(input);
		if(id.contentEquals("direct-vm://step1")){
			return "direct-vm://step1";
		}else if(id.contentEquals("direct-vm://step2")){
			return "direct-vm://step2";
		}
		return "direct-vm://error";
	}


}

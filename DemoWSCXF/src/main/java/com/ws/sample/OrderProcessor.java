package com.ws.sample;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderProcessor  implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		InputOrder input = exchange.getIn().getBody(InputOrder.class);
		OutputResult output=new OutputResult();
		output.setOutput( input.getName() );
		
		exchange.getOut().setBody(output);
	}

}

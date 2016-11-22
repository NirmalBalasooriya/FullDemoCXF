package com.demo.order;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderProcessor  implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Input input = exchange.getIn().getBody(Input.class);
		Output output=new Output();
		output.setName(input.getfName()+" "+input.getlName());
		output.setStatus("OK");
		output.setCompanyCode(input.getCompanyCode());
		output.setOrderNum(input.getOrderNum());
		exchange.getOut().setBody(output);
	}

}

package com.demo.order;

import javax.xml.namespace.QName;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.ws.sample.InputOrder;
import com.ws.sample.OutputResult;
import com.ws.sample.ServiceInterfaceWS;
import com.ws.sample.ServiceInterfaceWSPortType;

public class SoapClientProcess implements Processor {
    private static final QName SERVICE_NAME = new QName("http://sample.ws.com/", "ServiceInterfaceWS");
    
	public InputOrder buildSoapRequest(String name,String num){
		InputOrder input=new InputOrder();
		input.setName(name);
		input.setNumber(num);
		
		return input;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		ServiceInterfaceWS ss = new ServiceInterfaceWS(ServiceInterfaceWS.WSDL_LOCATION, SERVICE_NAME);
        ServiceInterfaceWSPortType port = ss.getServiceInterfaceWSPort();
        
        InputOrder inputOrder = new InputOrder();
        inputOrder.setName("Nirmal");
        inputOrder.setNumber("1");
        System.out.println("Before call by web service");
        
        OutputResult output = port.getWSoutput(inputOrder);
        
        System.out.println(output.getOutput());
        
	}
	
	
}

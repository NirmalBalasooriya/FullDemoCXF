package com.demo.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyRoute extends RouteBuilder {

	private String uri = "cxf:/incident?serviceClass=" + DemoOrderService.class.getName();
	String value;
	@Override
	public void configure() throws Exception {
		
		 
		// TODO Auto-generated method stub
		from(uri)
		.to("log:input"+value)
        // send the request to the route to handle the operation
        // the name of the operation is in that header
        .recipientList(simple("direct:${header.operationName}"));

    // report incident
		from("direct:provideOrder")
        .process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                 /*get the id of the input*/
            	Input input = exchange.getIn().getBody(Input.class);
                String id = input.getOrderNum();

                 /*set reply including the id*/
                Output output = new Output();
                output.setStatus("OK;" + id);
                String route=getRouteValueDB(input.getfName());
                System.out.println("Route "+route);
                exchange.getOut().setHeader("sample", route);
                exchange.getOut().setBody(output);
                exchange.setProperty("todynamic", "log:output{body}");
                value="log:output{body}";
            }
        }).recipientList(header("sample").tokenize(",")).end();
        
		
		from("direct:fileA").log("Before call web service fileA route").process(new SoapClientProcess()).log("Direct fileA");
		from("direct:fileB").log("Direct fileB");
		from("direct:fileC").log("Direct fileC");
		
		
		
	}
	private static String getRouteValueDB(String messageType){
    	String route=null;
    	try{  
	    	   Class.forName("com.mysql.jdbc.Driver");  
	    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","password");  
	    	   //here sonoo is database name, root is username and password  
	    	   Statement stmt=con.createStatement();  
	    	   ResultSet rs=stmt.executeQuery("select demo.t_routing_sequence.* from demo.t_routing_sequence "+
	    			   "left join demo.t_routing_entry on demo.t_routing_entry.router = demo.t_routing_sequence.router_id "+
	    			   "where demo.t_routing_entry.mesage_type='"+messageType+"'");  
	    	   int i=0;
	    	   
	    	   while(rs.next()){
		    	   i++;
		    	   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		    	   if(route==null){
			    	   route=rs.getNString("connector");
		    	   }else{
			    	   route+=","+rs.getNString("connector");
		    	   }
	    	   } 
	    	   
	    	   con.close();	    
	    	  
	   }catch(Exception e){
		   System.out.println(e);
	   }
    	 return route;
    }
}
class MyAggregationStrategy implements AggregationStrategy {
    @Override
    public org.apache.camel.Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        System.out.println("Aggregate called with oldExchange = " + (oldExchange == null ? "null" :
                oldExchange.getIn().getBody().toString()) + ", newExchange = " +
                newExchange.getIn().getBody().toString());
        Input input=oldExchange.getIn().getBody(Input.class);
        if(input.getOrderNum().equalsIgnoreCase("1")){
        	input.setfName(input.getfName()+"####1");
        	newExchange.getOut().setBody(input);
        }else{
        	input.setfName(input.getfName()+"####OTHER");
        	newExchange.getOut().setBody(input);
        	
        }
        return newExchange;
    }
    
    
}

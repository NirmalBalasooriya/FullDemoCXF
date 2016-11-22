package com.demo.order;
import java.io.File;
import java.sql.*;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class ObjectToXml implements Processor { 
private static final Logger log = Logger.getLogger("mockSql");
@Override
public void process(Exchange exchange) throws Exception {

    System.out.println("MyProcessor started");

    Input order = exchange.getIn().getBody(Input.class);

    try {

           // create JAXB context and initializing Marshaller
           JAXBContext jaxbContext = JAXBContext.newInstance(Input.class);
           Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

           // for getting nice formatted output
           jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

           
           
       	   try{  
	    	   Class.forName("com.mysql.jdbc.Driver");  
	    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","password");  
	    	   //here sonoo is database name, root is username and password  
	    	   Statement stmt=con.createStatement();  
	    	   ResultSet rs=stmt.executeQuery("select * from t_simple_order");  
	    	   int i=0;
	    	   while(rs.next()){
		    	   i++;
		    	   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	    	   }  
	    	   con.close();
	    	   order.setOrderNum( String.valueOf(i) );
    	   }catch(Exception e){
    		   System.out.println(e);
    	   }  
 
       	//specify the location and name of xml file to be created
           Calendar cal = Calendar.getInstance();
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		   String dateStr = dateFormat.format(cal.getTime());
           String fileName=dateStr+"_"+order.getOrderNum()+".xml";
           File XMLfile = new File("C:\\Demo\\wsFiles\\"+fileName);
           XMLfile.getParentFile().mkdirs();
           XMLfile.createNewFile();
           order.setTimeStamp(dateStr);
           
           // Writing to XML file
           jaxbMarshaller.marshal(order, XMLfile); 
           // Writing to console
           //jaxbMarshaller.marshal(order, System.out); 
           
           exchange.getOut().setBody(order);

          } catch (JAXBException e) {
           // some exception occured
           e.printStackTrace();
          }

         }

}
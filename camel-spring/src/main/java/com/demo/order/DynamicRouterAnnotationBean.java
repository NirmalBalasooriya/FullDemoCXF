package com.demo.order;

import org.apache.camel.DynamicRouter;
import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouterAnnotationBean {
	@DynamicRouter
    public String route(String body, @Header(Exchange.SLIP_ENDPOINT) String previous) {
     System.out.println("**************route, body-"+body+", previous-"+previous);
        if (previous == null) {
            // 1st time
            return "direct://a";
        } else if ("direct://a".equals(previous)) {
            // 2nd time -
            return "direct://b";
        } else if ("direct://b".equals(previous)) {
            // 2nd time -
            return "direct://d,direct://c";
        } else if ("direct://c".equals(previous)) {
         // 3rd time - transform the message body using the simple language
            return "direct://d";
        } else if ("direct://d".equals(previous)) {
            // 3rd time - transform the message body using the simple language
            return "language://simple:Bye ${body}";
        } else {
            // no more, so return null to indicate end of dynamic router
            return null;
        }
    }
}


package com.ws.sample;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ws.sample package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWSoutput_QNAME = new QName("http://sample.ws.com/", "getWSoutput");
    private final static QName _GetWSoutputResponse_QNAME = new QName("http://sample.ws.com/", "getWSoutputResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ws.sample
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWSoutput }
     * 
     */
    public GetWSoutput createGetWSoutput() {
        return new GetWSoutput();
    }

    /**
     * Create an instance of {@link InputOrder }
     * 
     */
    public InputOrder createInputOrder() {
        return new InputOrder();
    }

    /**
     * Create an instance of {@link OutputResult }
     * 
     */
    public OutputResult createOutputResult() {
        return new OutputResult();
    }

    /**
     * Create an instance of {@link GetWSoutputResponse }
     * 
     */
    public GetWSoutputResponse createGetWSoutputResponse() {
        return new GetWSoutputResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWSoutput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sample.ws.com/", name = "getWSoutput")
    public JAXBElement<GetWSoutput> createGetWSoutput(GetWSoutput value) {
        return new JAXBElement<GetWSoutput>(_GetWSoutput_QNAME, GetWSoutput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWSoutputResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sample.ws.com/", name = "getWSoutputResponse")
    public JAXBElement<GetWSoutputResponse> createGetWSoutputResponse(GetWSoutputResponse value) {
        return new JAXBElement<GetWSoutputResponse>(_GetWSoutputResponse_QNAME, GetWSoutputResponse.class, null, value);
    }

}

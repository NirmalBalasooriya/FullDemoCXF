package com.demo.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Input {
	@XmlElement(name = "fName", required=true)
	private String fName;
	
	@XmlElement(name = "lName")	
	private String lName;
	
	@XmlElement(name = "age")	
	private String age;
	
	@XmlElement(name = "country")	
	private String country;
	
	@XmlElement(name = "companyCode", required=true)		
	private String companyCode;
	
	@XmlElement(name = "orderNum", required=true)	
	private String orderNum;
	
	@XmlElement(name = "productCode", required=true)	
	private String productCode;
	
	@XmlElement(name = "netWeight", required=true)	
	private String netWeight;
	
	@XmlElement(name = "unitOfMesure", required=true)	
	private String unitOfMesure;
	
	@XmlElement(name = "portOfLoading", required=true)	
	private String portOfLoading;
	
	@XmlElement(name = "portOfDischarge", required=true)	
	private String portOfDischarge;
	
	@XmlElement(name = "shipper", required=true)	
	private String shipper;
	
	@XmlElement(name = "salesOrderNumber", required=true)	
	private String salesOrderNumber;
	
	@XmlElement(name = "purchaseOrderNumber")	
	private String purchaseOrderNumber;	
	
	@XmlElement
	private String timeStamp;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}
	public String getUnitOfMesure() {
		return unitOfMesure;
	}
	public void setUnitOfMesure(String unitOfMesure) {
		this.unitOfMesure = unitOfMesure;
	}
	public String getPortOfLoading() {
		return portOfLoading;
	}
	public void setPortOfLoading(String portOfLoading) {
		this.portOfLoading = portOfLoading;
	}
	public String getPortOfDischarge() {
		return portOfDischarge;
	}
	public void setPortOfDischarge(String portOfDischarge) {
		this.portOfDischarge = portOfDischarge;
	}
	public String getShipper() {
		return shipper;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public String getSalesOrderNumber() {
		return salesOrderNumber;
	}
	public void setSalesOrderNumber(String salesOrderNumber) {
		this.salesOrderNumber = salesOrderNumber;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}

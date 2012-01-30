package com.dimitrisli.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.dimitrisli.jaxb.producedClasses.OrderType;
import com.dimitrisli.jaxb.producedClasses.Root;
import com.dimitrisli.jaxb.producedClasses.CustomerType;

public class MainExample {

	public static void main(String[] args) throws JAXBException,
			FileNotFoundException {
		JAXBContext context = JAXBContext
				.newInstance("com.dimitrisli.jaxb.producedClasses");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Root root = (Root) unmarshaller.unmarshal(new FileInputStream(
				"src/main/resources/sampleXml/CustomersOrders.xml"));
		
		System.out.println("first get customers:");
		System.out.println("====================");
		for (CustomerType currentCustomer : root.getCustomers().getCustomer()) {
			System.out.println(currentCustomer.getCompanyName());
			System.out.println(currentCustomer.getContactName());
			System.out.println(currentCustomer.getContactTitle());
			System.out.println(currentCustomer.getCustomerID());
			System.out.println(currentCustomer.getFullAddress());
			System.out.println(currentCustomer.getPhone());
			System.out.println("-----");
		}
		System.out.println("then get orders:");
		System.out.println("====================");
		for (OrderType currentOrder : root.getOrders().getOrder()) {
			System.out.println(currentOrder.getCustomerID());
			System.out.println(currentOrder.getEmployeeID());
			System.out.println(currentOrder.getOrderDate());
			System.out.println(currentOrder.getShipInfo().getShipAddress());
			System.out.println(currentOrder.getShipInfo().getShipName());
			System.out.println(currentOrder.getShipInfo().getShipName());
			System.out.println("-----");
		}
	}
}

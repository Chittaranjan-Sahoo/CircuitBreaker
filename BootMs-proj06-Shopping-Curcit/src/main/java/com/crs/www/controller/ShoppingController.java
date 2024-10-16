package com.crs.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.www.client.IBillingServiceConsumer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	
	@Autowired
	private IBillingServiceConsumer ser;
	
	@GetMapping("/data")
	@CircuitBreaker(name="Shopping-Service",fallbackMethod="billingFallback")
	public ResponseEntity<String> displayShoppingDetails()
	{
       System.out.println("from shopping method of shopping service()");
       String msg=ser.fetchBillDetails();
       String finalmsg="shooping of shirt trouser done"+msg;
		return new ResponseEntity<String>(finalmsg,HttpStatus.OK);
	}
	public ResponseEntity<String> billingFallback(Exception se)
	{
		System.out.println("Shoppling service fallback");
		return new ResponseEntity<String>("Billing operation out of service",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
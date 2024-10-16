package com.crs.www.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@Value("${server.port}")
	private int port;
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	@GetMapping("/info")
	public String getBillingInfo()
	{
		System.out.println("From billing service()");
		return "we accept card payment,online payment,cash payment port:"+port+" Instance: "+instanceId;
	}
}

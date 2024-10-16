package com.crs.www.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Curcit")
public interface IBillingServiceConsumer {

	@GetMapping("/billing/info")
	public String fetchBillDetails();
}

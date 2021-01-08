package org.ssl.examples.customer.service;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class OrderServicenfoContributor  implements InfoContributor{
	
	
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the Customer service, which is discovery server aware, and this service will be Called by order Microservice, for customer details, which is again dicovery server aware!!! "));
	}

}

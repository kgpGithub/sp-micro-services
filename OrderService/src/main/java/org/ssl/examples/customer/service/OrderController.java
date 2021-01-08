package org.ssl.examples.customer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.ssl.examples.customer.dto.Order;
@RestController
public class OrderController {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	  private final List<Order> orders = Arrays.asList(
	            new Order(1, 1, "Product A"),
	            new Order(2, 1, "Product B"),
	            new Order(3, 2, "Product C"),
	            new Order(4, 1, "Product D"),
	            new Order(5, 2, "Product E"));

	    @GetMapping
	  //  @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, headers = "Accept=application/json")
	    public List<Order> getAllOrders() {
	    	System.out.println("getAllOrders microservices");
	    	String response = restTemplate.exchange("http://customer-service/", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
			}).getBody();
	    	System.out.println(response);
	        return orders;
	    }
	    /*
	     * @RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("Getting School details for " + schoolname);
		String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}, schoolname).getBody();

		System.out.println("Response Received as " + response);

		return "School Name -  " + schoolname + " \n Student Details " + response;
	}
	     */

	    @GetMapping("/{id}")
	   // @RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public Order getOrderById(@PathVariable int id) {
	        return orders.stream()
	                     .filter(order -> order.getId() == id)
	                     .findFirst()
	                     .orElseThrow(IllegalArgumentException::new);
	    }

}

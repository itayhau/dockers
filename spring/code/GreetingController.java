
package com.example.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
static List<Coupon> coupons = new ArrayList<Coupon>();
	
	static {
		coupons.add( new Coupon(1, "Caffe") );
		coupons.add( new Coupon(2, "Movie VIP") );
		coupons.add( new Coupon(3, "Sky jump") );	
	}

	@RequestMapping( value = "/coupon", method = RequestMethod.GET)
	public List<Coupon> doGetCoupons()
	{
		return coupons;
	}
	
	@RequestMapping( value = "/coupon/{id}", method = RequestMethod.GET)
	public Coupon doGetCouponById(@PathVariable("id") int id)
	{
		for(Coupon c : coupons)
		{
			if (c.getId() == id)
			{
				return c;
			}
		}
		return null;
	}	
	
	
	@RequestMapping( value = "/coupon", method = RequestMethod.POST)
	public String doPostCoupons(@RequestBody Coupon c)
	{
		coupons.add(c);
		return "Success!";
	}
	
	@RequestMapping( value = "/coupon/{id}", method = RequestMethod.PUT)
	public String doPutCoupons(@RequestBody Coupon sent, @PathVariable("id") int id)
	{
		for(Coupon c : coupons)
		{
			if (c.getId() == id)
			{
				c.setId( sent.getId());
				c.setTitle( sent.getTitle());
				return "UPDATED!";
			}
		}
		return "NOT FOUND!";
	}
	
	@RequestMapping( value = "/coupon/{id}", method = RequestMethod.DELETE)
	public String doDeleteCoupons(@PathVariable("id") int id)
	{
		Coupon del = null;
		for(Coupon c : coupons)
		{
			if (c.getId() == id)
			{
				del = c;
			}
		}
		if (del != null)
		{
			coupons.remove(del);
			return "Coupon deleted!";
		}
		return "Coupon not found!";
	}
}
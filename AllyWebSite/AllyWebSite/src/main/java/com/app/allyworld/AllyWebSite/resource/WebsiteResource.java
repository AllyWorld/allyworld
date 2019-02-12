package com.app.allyworld.AllyWebSite.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.allyworld.AllyWebSite.enitity.Profile;

@Controller
public class WebsiteResource {

	@Autowired
	private RestTemplate template;

	@RequestMapping("/")
	public String home() {
		return "RegistrationForm";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("profile") Profile profile ) {
		System.out.println("allyworld");
		
		  System.out.println(profile);
		  template.postForEntity("http://localhost:2013/profiles", profile,Profile.class);
		 
		return new ModelAndView("hello", "msg", "hello brother");

	}

}

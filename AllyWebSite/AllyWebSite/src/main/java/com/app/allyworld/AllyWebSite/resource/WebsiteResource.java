package com.app.allyworld.AllyWebSite.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.allyworld.AllyWebSite.enitity.LoginCredentials;
import com.app.allyworld.AllyWebSite.enitity.Profile;

@Controller
public class WebsiteResource {

	@Autowired
	private RestTemplate template;

	Profile profile;
	int profileId;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("profile") Profile profile) {
		System.out.println("allyworld");
		System.out.println(profile);
		System.out.println(profile.getLogin().getEmail());
		template.postForEntity("http://localhost:2013/profiles", profile, Profile.class);
		return new ModelAndView("index", "message", "Registration Success");

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm(@ModelAttribute LoginCredentials loginCreditials) {
		String email = loginCreditials.getEmail();
		System.out.println(email);
		ResponseEntity<Profile> entity = template.getForEntity(
				"http://localhost:2013/profiles?email=" + email + "&password=" + loginCreditials.getPassword(),
				Profile.class, loginCreditials);
		profile = entity.getBody();
		return new ModelAndView("home", "message", "Invalid user name and password");

	}

	@RequestMapping("/Profile")
	public ModelAndView viewingProfile() {
		profileId = profile.getProfileId();
		ResponseEntity<Profile> profileEntity = template.getForEntity("http://localhost:2013/profiles/" + profileId,
				Profile.class, profileId);
		System.out.println(profileEntity.getBody());
		return new ModelAndView("Profile", "message", profile);
	}

	@RequestMapping(value = "/Profilepage")
	public void profile(@ModelAttribute Profile profile) {
		System.out.println("Profile method profile id " + profileId);
	}

	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}
	
	/*
	 * @RequestMapping("/searchPeople") public ModelAndView
	 * searchPeople(@RequestParam String name, Model model) { List<Profile> people =
	 * template.getForEntity("http://localhost:2013/profiles",);
	 * model.addAttribute("people", people); return ""; }
	 */

}

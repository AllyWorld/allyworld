package com.allyworld.app.profileservice.controllertest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.allyworld.app.profileservice.entity.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ProfileResourceTesting {
	Profile profileTest;
	Profile profileTest1;
	Profile profileTest2;
	Profile profileTest3;

	@Autowired
	TestRestTemplate template;

	@Before
	public void setUp() {
		/*
		 * profileTest = new Profile("priyanka", "priyanka reddivari", "female", null,
		 * 9985617661L, "single", "Mumbai", "Tamil Nadu", null, null); profileTest1 =
		 * new Profile("Mrudula123", "Mrudula Nimmala", "female", null, 102347661L,
		 * "single", "Mumbai", "Macherla", null, null); profileTest2 = new
		 * Profile("Sweety", "Vineela", "female", null, 5231462L, "single", "Guntur",
		 * "Macherla", null, null); profileTest3 = new Profile("priyanka",
		 * "priyanka reddivari", "female", null, 2100356545L, "single", "Mumbai",
		 * "Tamil Nadu", null, null);
		 */

	}

	@Test
	public void testForGetProfileById() {

		ResponseEntity<Profile> profile = template.getForEntity("/profiles/101", Profile.class);
		assertThat(profile.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);

	}

	@Test
	public void testForNotGettingProfileById() {
		ResponseEntity<Profile> profile = template.getForEntity("/profiles/124", Profile.class);
		assertThat(profile.getStatusCode()).isEqualByComparingTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void addNewProfileTesting() {
		ResponseEntity<Profile> entity = template.postForEntity("/profiles", profileTest3, Profile.class);
		assertThat(entity.getBody().getFullName()).isEqualTo(profileTest3.getFullName());
	}

	@Test
	public void getProfilesTest() {
		ResponseEntity<List> profileList = template.getForEntity("/profiles", List.class);
		System.out.println(profileList.getBody());
		assertEquals(HttpStatus.OK, profileList.getStatusCode());

	}

	@Test
	public void updateProfileTest() {
		template.put("/profiles", profileTest);
		ResponseEntity<Profile> profileTest = template.getForEntity("/profiles/100", Profile.class);

		assertEquals(HttpStatus.OK, profileTest.getStatusCode());
	}

	@Test
	public void deleteProfileTest() {
		template.delete("/profiles/100", Profile.class);
		ResponseEntity<Profile> profile = template.getForEntity("/profiles/100", Profile.class);
		assertEquals(HttpStatus.NOT_FOUND, profile.getStatusCode());
	}

	@Test
	public void deleteAllProfiles() {
		template.delete("/profiles", Profile.class);
		ResponseEntity<List> profileList = template.getForEntity("/profiles", List.class);
		assertEquals(HttpStatus.OK, profileList.getStatusCode());
	}

}

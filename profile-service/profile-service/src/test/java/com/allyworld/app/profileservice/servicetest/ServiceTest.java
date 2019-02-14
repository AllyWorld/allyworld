package com.allyworld.app.profileservice.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.allyworld.app.profileservice.entity.Profile;
import com.allyworld.app.profileservice.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	Profile profileTest;
	Profile profileTest1;
	Profile profileTest2;
	Profile profileTest3;
	@Autowired
	private ProfileService service;

	@Test
	public void testForAddNewProfile() {

		/*
		 * profileTest = new Profile("priyanka", "priyanka reddivari", "female", null,
		 * 10235487L, "single", "Mumbai", "Tamil Nadu", null, null);
		 */
		service.addNewProfile(profileTest);
		System.out.println(profileTest.toString());
		assertEquals(
				"Profile [profileId=100, userName=priyanka, fullName=priyanka reddivari, gender=female, dateOfBirth=null, phoneNumber=10235487, relationShipStatus=single, currentAddress=Mumbai, permanentAddress=Tamil Nadu, friendsList=null, pendingFriendList=null]",
				profileTest.toString());

	}

	@Test
	public void getProfileById() {
		Optional<Profile> profile = service.getProfileById(130);
		assertEquals("priyanka reddivari", profile.get().getFullName());

	}

	@Test
	public void getProfilesTest() {
		/*
		 * ResponseEntity<List<Profile>> profileList = service.getProfiles();
		 * System.out.println(profileList.toString()); // assertEquals("Profile
		 * [profileId=130, userName=priyanka, fullName=priyanka // reddivari,
		 * gender=female, dateOfBirth=null, phoneNumber=9985617661, //
		 * relationShipStatus=single, currentAddress=Mumbai, permanentAddress=Tamil //
		 * Nadu, friendsList=null, pendingFriendList=null], Profile [profileId=100, //
		 * userName=priyanka, fullName=priyanka reddivari, gender=female, //
		 * dateOfBirth=null, phoneNumber=10235487, relationShipStatus=single, //
		 * currentAddress=Mumbai, permanentAddress=Tamil Nadu, friendsList=null, //
		 * pendingFriendList=null]]", profileList);
		 */		assertEquals(HttpStatus.OK, service.getProfiles().getStatusCode());

	}

	@Test
	public void deleteProfileTest() {
		/*
		 * profileTest = new Profile("priyanka", "priyanka reddivari", "female", null,
		 * 10235487L, "single", "Mumbai", "Tamil Nadu", null, null);
		 */
		service.addNewProfile(profileTest);

		assertEquals(HttpStatus.OK, service.deleteProfile(profileTest).getStatusCode());
	}

}

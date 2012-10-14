package com.rest.api.samples.tests;

import junit.framework.Assert;
import com.rest.api.samples.models.*;
import org.junit.Before;
import org.junit.Test;

import com.rest.api.samples.ContactHelper;


public class ContactHelperTests 
{
	private ContactHelper _helper;

	@Before
	public void Setup() 
	{
		_helper = new ContactHelper("site", "user", "password", "https://secure.eloqua.com/API/REST/1.0");
	}
	
	@Test
	public void GetContactTest()
	{
		int id = 152365;
		Contact contact = _helper.GetContact(id);
		Assert.assertEquals(id, contact.id);
	}
	
	@Test
	public void GetContactsTest() 
	{
		SearchResponse<Contact> contacts = _helper.GetContacts("*", 1, 10);
		Assert.assertTrue(contacts.total > 0);
	}
}

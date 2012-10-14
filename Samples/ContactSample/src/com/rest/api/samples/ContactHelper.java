package com.rest.api.samples;

import com.rest.api.*;
import com.rest.api.samples.models.*;
import com.google.gson.Gson;

public class ContactHelper 
{
	private Client _client;
	
	public ContactHelper(String site, String user, String password, String baseUrl) 
	{
		_client = new Client(site + "\\" + user, password, baseUrl);
	}
	
	public Contact GetContact(int id)
	{
		Contact contact = new Contact();
		
		try 
		{
			Response response = _client.get("/data/contact/" + String.valueOf(id));
			Gson gson = new Gson();
			contact = gson.fromJson(response.body, Contact.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();			
		}
		return contact;
	}
	
	public SearchResponse<Contact> GetContacts(String search, int page, int count) 
	{
		SearchResponse<Contact> contacts = null;
		try 
		{
			Response response = _client.get("/data/contacts?search=" + search + "&page=" + page + "&count=" + count);
			Gson gson = new Gson();
	        contacts = gson.fromJson(response.body, SearchResponse.class);	        
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return contacts;
	}
}

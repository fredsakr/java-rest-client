package com.rest.api.samples.models;

import java.util.List;

public class SearchResponse<T> 
{
	public List<T> elements;
	public int total;
	public int page;
	public int pageSize;
}

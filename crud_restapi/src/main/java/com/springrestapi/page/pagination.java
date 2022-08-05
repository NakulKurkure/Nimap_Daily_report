package com.springrestapi.page;

//import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class pagination {

	public pagination() {
		super();
		
	}

	public Pageable getPagination(String pageNumber,String pageSize)
	{
		return  PageRequest.of(Integer.parseInt(pageNumber)-1, Integer.parseInt(pageSize));
	}
}
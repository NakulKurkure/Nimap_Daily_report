package com.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination {

	//Abstract interface for pagination information.
		public Pageable getPagination(String pageNumber,String pageSize)
		{
			System.out.println("pageNumber"+pageNumber+pageSize);
			return PageRequest.of(Integer.parseInt(pageNumber)-1, Integer.parseInt(pageSize));


		}

		public Pagination() {
			super();
			
		}
	
}

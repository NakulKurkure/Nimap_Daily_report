package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.springrestapi.dto.EntityDto;
import com.springrestapi.dto.UserDto;
import com.springrestapi.errordto.SuccessResponseDto;
//import com.springrestapi.repo.Entity_repo;
import com.springrestapi.repo.UserRepo;
//import com.springrestapi.service.Entity_service;
import com.springrestapi.service.UserService;

@RestController
@RequestMapping("/user")
//@EnableCaching
//@CacheConfig(cacheNames = "logs")
//@EnableRedisRepositories
public class UserController {

@Autowired
private UserService userService;

//		@PreAuthorize("hasRole('getProducts')")
		@GetMapping("/check")

//		@PreAuthorize("hasRole('getProducts')")
		//ResponseEntity represents the whole HTTP response: status code, headers, and body.
		public ResponseEntity<?> getProducts(@RequestParam(defaultValue = "") String search,
				@RequestParam(defaultValue = "1") String pageNumber,
				@RequestParam(defaultValue = "5") String pageSize)
		{
			//ResponseEntity is meant to represent the entire HTTP response
			Page<?> entity= userService.getProducts(search,pageNumber,pageSize);
			if(entity.getTotalElements()!=0)
			{
				return new ResponseEntity<>(entity.getContent(), HttpStatus.OK);
			}
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}


//		@PreAuthorize("hasRole('getuserid')")
		@GetMapping("/{id}")
//		@Cacheable(key="#id")
		
		public ResponseEntity<?> getByid(@PathVariable Integer id)
		{
//		 this.entity_service.getid(id);
			return new ResponseEntity<>(new SuccessResponseDto("Success","success",userService.getid(id)),HttpStatus.OK);
//			return new ResponseEntity<>(entiy,HttpStatus.CREATED);

		}



		@PutMapping("/{id}")
		public ResponseEntity<?> update(@RequestBody UserDto e,@PathVariable Integer id)
		{

			UserDto entitydto=userService.update(e, id);

			return new ResponseEntity<>(new SuccessResponseDto("S","ok", entitydto),HttpStatus.ACCEPTED);
//			this ResponseEntity<>(new SuccessResponseDto("success","success",entity_service.update(e,id)));

//			return entity;

		}


		@DeleteMapping("/{id}")
		public void delete(@PathVariable Integer id)
		{
			this.userService.deleteEntity(id);

		}




	}



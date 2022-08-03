package com.springrestapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.springrestapi.dto.EntityDto;
import com.springrestapi.dto.UserDto;
import com.springrestapi.entity.User;
//import com.springrestapi.User.User;
//import com.springrestapi.User.User;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.page.pagination;
//import com.springrestapi.repo.Entity_repo;
import com.springrestapi.repo.UserRepo;
//import com.springrestapi.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo entity_repository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelmapper;

	public UserDto add(UserDto entityDto)
	{
		//convert dto to User
		User user= this.dtoToUser(entityDto);
		//save to database
		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);

		User entity1=this.entity_repository.save(user);

		return this.userDto(entity1);

	}


	public UserDto getid(Integer id) {

		User user= this.entity_repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("NOt found"+id));

		return this.userDto(user);

	}

	public UserDto update(UserDto userdto,Integer id) {


		//save to database
//		User User= entity_repository.save(User);
		User user= entity_repository.findById(id).orElseThrow(()->new ResourseNotFoundException("Not Found"+id));
		//conversion of User to dto
		user.setEmail(userdto.getEmail());
		
		String password=passwordEncoder.encode(userdto.getPassword());
		user.setPassword(password);

		user.setUserName(userdto.getUserName());

		User updateUser=this.entity_repository.save(user);
		return this.modelmapper.map(updateUser, UserDto.class);
	}


//		User updateEntity=this.entity_repository.save(user);
//		UserDto entitydto1=userDto(updateEntity);
//		return entitydto1;
//	}

	public void deleteEntity(Integer id) {


//		Fetch the record from the db
//		User User = entity_repository.getById(id);
//
//
//		//Update the is_active attr to false
//		User.setIsActive(false);
//
//		//Save the record
//		this.entity_repository.save(User);

	//only show for user is data deleted but actual data is not deleted form database.
//  this.entity_repository.findById(id).orElseThrow(()->new ResourseNotFoundException("Not found"));
	this.entity_repository.deleteById(id);

}


	public Page<?> getProducts(String search, String pageNumber, String pageSize) {
		// TODO Auto-generated method stub

//		Pageable is an Integeregererface defined by Spring, which holds a PageRequest.
//		/Abstract Integeregererface for pagination information
		Pageable pagable=new pagination().getPagination(pageNumber,pageSize);

				if((search=="")|| (search==null)|| (search.length()==0))
				{
					return entity_repository.findAll(pagable);
				}
				else
				{
					return entity_repository.findByUserName(search,pagable,User.class);
				}


	}

	//only this data shown for user
	public User dtoToUser(UserDto entitydto)
	{
		User user=this.modelmapper.map(entitydto, User.class);
		return user;
	}



	public UserDto userDto(User user)
	{
		//User to represent to EntityDto (3 fis returns)
		UserDto entitydto=this.modelmapper.map(user, UserDto.class);
		return entitydto;
	}


}

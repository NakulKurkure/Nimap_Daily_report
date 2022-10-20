package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.RoleDto;
import com.entity.Role;
import com.exception.ResourceNotFoundException;
import com.repository.RoleRepository;
import com.serviceInterface.IRoleListDto;
import com.serviceInterface.RoleServiceInterface;
import com.util.Pagination;

@Service
public class RoleServiceImpl implements RoleServiceInterface{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRole(RoleDto roleDto) {
		Role role=new Role();
		role.setRoleName(roleDto.getRoleName());
		role.setDescription(roleDto.getDescription());

		roleRepository.save(role);


		
	}

	@Override
	public RoleDto getByRoleId(Long id) {


		Role role=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId."));

		RoleDto roleDto=new RoleDto();
		roleDto.setRoleName(role.getRoleName());
		roleDto.setDescription(role.getDescription());

		return roleDto;
	}

	@Override
	public RoleDto updateRoleById(RoleDto roleDto, Long id) {
		
		Role role=roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId."));


		role.setDescription(roleDto.getDescription());
		role.setRoleName(roleDto.getRoleName());

		roleRepository.save(role);

		
		return null;
	}

	@Override
	public void deleteRoleById(Long id) {
	
		roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId."));
		
		roleRepository.deleteById(id);
		
	}

	@Override
	public Page<IRoleListDto> getAllRoles(String search, String pageNumber, String pageSize) {
		
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);

		if((search=="")||(search==null)||search.length()==0)
		{
			return roleRepository.findByOrderByRoleIdDesc(pagable,IRoleListDto.class);
		}
		else
		{
			return roleRepository.findByRoleName(search,pagable,IRoleListDto.class);
		}


	}

}

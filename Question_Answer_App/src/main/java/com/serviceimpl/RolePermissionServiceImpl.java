package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.RolePermissionRequestDto;
import com.entity.PermissionEntity;
import com.entity.RoleEntity;
import com.entity.RolePermissionEntity;
import com.entity.RolePermissionId;
import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.entity.UserRoleId;
import com.exception.ResourceNotFoundException;
import com.repository.PermissionRepository;
import com.repository.RolePermissionRepository;
import com.repository.RoleRepository;
import com.serviceInterface.RolePermissionServiceInterface;

@Service
public class RolePermissionServiceImpl implements RolePermissionServiceInterface{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
	
	@Override
	public void addRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		// TODO Auto-generated method stub
		
		ArrayList<RolePermissionEntity> RolePermission = new ArrayList<>();
		
		RoleEntity roleId=this.roleRepository.findById(rolePermissionRequestDto.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));

		PermissionEntity permissionId=this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId()).orElseThrow(()-> new ResourceNotFoundException("Not Found PermissionId"));
		
		RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
		RolePermissionId RolePermissionId=new RolePermissionId(roleId,permissionId);
		rolePermissionEntity.setPk(RolePermissionId);

		RolePermission.add(rolePermissionEntity);
		//save in database
		rolePermissionRepository.saveAll(RolePermission);
	
	}

	@Override
	public void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		
		RoleEntity roleEntity=this.roleRepository.findById(rolePermissionRequestDto.getRoleId()).get();
		PermissionEntity permissionEntity=this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId()).get();
		
		RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
		RolePermissionId rolePermissionId=new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		this.rolePermissionRepository.updateRolePermission(roleEntity.getId(),permissionEntity.getId());
		
	}

	@Override
	public void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		// TODO Auto-generated method stub
		
		RoleEntity roleEntity=this.roleRepository.findById(rolePermissionRequestDto.getRoleId()).get();
		PermissionEntity permissionEntity=this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId()).get();
		
		RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
		RolePermissionId rolePermissionId=new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		rolePermissionRepository.delete(rolePermissionEntity);
	}

	@Override
	public List<RolePermissionEntity> getAll() {
		
			return this.rolePermissionRepository.findAll();
		}

	
}

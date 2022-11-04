package com.job.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.dto.RolePermissionRequestDto;
import com.job.entity.Permission;
import com.job.entity.Role;
import com.job.entity.RolePermission;
import com.job.serviceInterface.RolePermissionServiceInterface;

@Service
public class RolePermissionServiceimpl implements RolePermissionServiceInterface{

	@Autowired
	private com.job.repository.RoleRepository roleRepository;
	
	@Autowired
	private com.job.repository.PermissionRepository permissionRepository;
	
	@Autowired
	private com.job.repository.RolePermissionRepository rolePermissionRepository;
	@Override
	public void addRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		
		ArrayList<RolePermission> RolePermission = new ArrayList<>();
		
		Role roleId=this.roleRepository.findById(rolePermissionRequestDto.getRoleId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found RoleId.."));
			
		Permission permissionId=this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found PermissionId.."));
		
		RolePermission rolePermissionEntity=new RolePermission();
		com.job.entity.RolePermissionId RolePermissionId=new com.job.entity.RolePermissionId(roleId,permissionId);
		rolePermissionEntity.setPk(RolePermissionId);

		RolePermission.add(rolePermissionEntity);
		//save in database
		rolePermissionRepository.saveAll(RolePermission);

		
	}

	@Override
	public void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		Role roleId=this.roleRepository.findById(rolePermissionRequestDto.getRoleId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found RoleId.."));
		
		Permission permissionId=this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found PermissionId.."));
		
		RolePermission rolePermissionEntity=new RolePermission();
		com.job.entity.RolePermissionId RolePermissionId=new com.job.entity.RolePermissionId(roleId,permissionId);
		rolePermissionEntity.setPk(RolePermissionId);
		rolePermissionRepository.updateRolePermission(roleId.getRoleId(),permissionId.getPermissionId());
		
		
	}

	@Override
	public void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		// TODO Auto-generated method stub
Role roleId=this.roleRepository.findById(rolePermissionRequestDto.getRoleId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found RoleId.."));
		
		Permission permissionId=this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId()).orElseThrow(()-> new com.job.exception.ResourceNotFoundException("Not Found PermissionId.."));
		
		RolePermission rolePermissionEntity=new RolePermission();
		com.job.entity.RolePermissionId RolePermissionId=new com.job.entity.RolePermissionId(roleId,permissionId);
		rolePermissionEntity.setPk(RolePermissionId);
		rolePermissionRepository.deleteRolePermission(roleId.getRoleId(),permissionId.getPermissionId());
	}

}

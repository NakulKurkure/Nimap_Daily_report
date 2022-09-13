package com.springrestapi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

//import com.app.exceptionsHandling.ResourceNotFoundException;
import com.springrestapi.entity.PermissionEntity;
import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.RolePermissionEntity;
import com.springrestapi.entity.RolePermissionId;
import com.springrestapi.errordto.ResourceNotFoundException;
//import com.springrestapi.exception.Errordetails;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.payload.RolePermissionRequest;
import com.springrestapi.repo.PermissionRepo;
import com.springrestapi.repo.RolePermissionRepo;
import com.springrestapi.repo.RoleRepo;
import com.springrestapi.repo.UserRoleRepo;
import com.springrestapi.service.PermissionIdList;
import com.springrestapi.service.RoleIdList;
import com.springrestapi.service.RolePermissionServiceInterface;

@Service
public class RolePermissionServiceImpl implements RolePermissionServiceInterface{

	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private RolePermissionRepo rolePermissionRepo;
	@Autowired
	private PermissionRepo permissionRepo;
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	@Override
	public void add(RolePermissionRequest rolePermissionRequest)  {
	
		
		try {
			ArrayList<RolePermissionEntity> permissions=new ArrayList<>();
			RoleEntity roleEntityId=this.roleRepo.findById(rolePermissionRequest.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Not Found roleId"));
			PermissionEntity permissionEntityId=this.permissionRepo.findById(rolePermissionRequest.getPermissionId()).orElseThrow(()-> new ResourceNotFoundException("Not Found permissionId"));
			
			RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
			
			RolePermissionId rolePermissionId=new RolePermissionId(roleEntityId,permissionEntityId);
			rolePermissionEntity.setPk(rolePermissionId);
			permissions.add(rolePermissionEntity);
			rolePermissionRepo.saveAll(permissions);
			
		} catch (Exception e) {
			
			
			System.out.print(e);
			e.printStackTrace();
//			throw new Errordetails(new Date(), "Not Found", "not found",HttpStatus.NOT_FOUND );
			throw new ResourseNotFoundException("Not found");
			
		}
		
		
	}

	@Override
	public List<RolePermissionEntity> getAll() {
		
		
		return this.rolePermissionRepo.findAll();
	}

	@Override
	public void updateRolePermission(RolePermissionRequest rolePermissionRequest) {
		
		
			RoleEntity roleEntity=this.roleRepo.findById(rolePermissionRequest.getRoleId()).get();
			PermissionEntity permissionEntity=this.permissionRepo.findById(rolePermissionRequest.getPermissionId()).get();
			
			RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
			RolePermissionId rolePermissionId=new RolePermissionId(roleEntity,permissionEntity);
			rolePermissionEntity.setPk(rolePermissionId);
			this.rolePermissionRepo.updateRolePermission(roleEntity.getId(),permissionEntity.getId());
			
		
	}

	@Override
	public void deleteRolePermission(RolePermissionRequest rolePermissionRequest) {
		// TODO Auto-generated method stub
		
		RoleEntity roleEntity=this.roleRepo.findById(rolePermissionRequest.getRoleId()).get();
		PermissionEntity permissionEntity=this.permissionRepo.findById(rolePermissionRequest.getPermissionId()).get();
		
		RolePermissionEntity rolePermissionEntity=new RolePermissionEntity();
		RolePermissionId rolePermissionId=new RolePermissionId(roleEntity,permissionEntity);
		rolePermissionEntity.setPk(rolePermissionId);
		rolePermissionRepo.delete(rolePermissionEntity);
	}

	@Override
	public ArrayList<String> getPermissionByUserId(int id) {
		// TODO Auto-generated method stub
		
		
		ArrayList<RoleIdList>  roleIds=userRoleRepo.findByPkUsersId(id, RoleIdList.class);
		
		ArrayList<Integer> roles=new ArrayList<>();
		for(int i=0;i<roleIds.size();i++)
		{
			roles.add(roleIds.get(i).getPkRolesId());
		}
		
		List<PermissionIdList> rolePermission=rolePermissionRepo.findPkPermissionByPkRolesIdIn(roles, PermissionIdList.class);
		
		System.out.print("Hello ");
		ArrayList<String> permission=new ArrayList<>();
		for(PermissionIdList element:rolePermission)
		{
			permission.add(element.getPkPermissionActionName());
		}
		return permission;
	}

//	@Override
//	public ArrayList<Permi> getPermissionByUserId(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

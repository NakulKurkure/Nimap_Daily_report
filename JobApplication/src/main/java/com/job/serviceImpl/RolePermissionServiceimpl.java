package com.job.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.dto.RolePermissionRequestDto;
import com.job.entity.Permission;
import com.job.entity.Role;
import com.job.entity.RolePermission;
import com.job.repository.UserRoleRepository;
import com.job.serviceInterface.IListRoleDto;
import com.job.serviceInterface.PermissionIdList;
import com.job.serviceInterface.RoleIdList;

import com.job.serviceInterface.RolePermissionServiceInterface;
import com.job.util.Pagination;

@Service
public class RolePermissionServiceimpl implements RolePermissionServiceInterface {

	@Autowired
	private com.job.repository.RoleRepository roleRepository;

	@Autowired
	private com.job.repository.PermissionRepository permissionRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private com.job.repository.RolePermissionRepository rolePermissionRepository;

	@Override
	public void addRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {

		ArrayList<RolePermission> RolePermission = new ArrayList<>();

		Role roleId = this.roleRepository.findById(rolePermissionRequestDto.getRoleId())
				.orElseThrow(() -> new com.job.exception.ResourceNotFoundException("Not Found RoleId.."));

		Permission permissionId = this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId())
				.orElseThrow(() -> new com.job.exception.ResourceNotFoundException("Not Found PermissionId.."));

		RolePermission rolePermissionEntity = new RolePermission();
		com.job.entity.RolePermissionId RolePermissionId = new com.job.entity.RolePermissionId(roleId, permissionId);
		rolePermissionEntity.setPk(RolePermissionId);

		RolePermission.add(rolePermissionEntity);
		// save in database
		rolePermissionRepository.saveAll(RolePermission);

	}

	@Override
	public void updateRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		Role roleId = this.roleRepository.findById(rolePermissionRequestDto.getRoleId())
				.orElseThrow(() -> new com.job.exception.ResourceNotFoundException("Not Found RoleId.."));

		Permission permissionId = this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId())
				.orElseThrow(() -> new com.job.exception.ResourceNotFoundException("Not Found PermissionId.."));

		RolePermission rolePermissionEntity = new RolePermission();
		com.job.entity.RolePermissionId RolePermissionId = new com.job.entity.RolePermissionId(roleId, permissionId);
		rolePermissionEntity.setPk(RolePermissionId);
		rolePermissionRepository.updateRolePermission(roleId.getRoleId(), permissionId.getPermissionId());

	}

	@Override
	public void deleteRolePermission(RolePermissionRequestDto rolePermissionRequestDto) {
		// TODO Auto-generated method stub
		Role roleId = this.roleRepository.findById(rolePermissionRequestDto.getRoleId())
				.orElseThrow(() -> new com.job.exception.ResourceNotFoundException("Not Found RoleId.."));

		Permission permissionId = this.permissionRepository.findById(rolePermissionRequestDto.getPermissionId())
				.orElseThrow(() -> new com.job.exception.ResourceNotFoundException("Not Found PermissionId.."));

		RolePermission rolePermissionEntity = new RolePermission();
		com.job.entity.RolePermissionId RolePermissionId = new com.job.entity.RolePermissionId(roleId, permissionId);
		rolePermissionEntity.setPk(RolePermissionId);
		rolePermissionRepository.deleteRolePermission(roleId.getRoleId(), permissionId.getPermissionId());
	}

	public ArrayList<String> getPermissionByUserId(Long userId) {
		// TODO Auto-generated method stub

		ArrayList<RoleIdList> roleIds = userRoleRepository.findByPkUserUserId(userId, RoleIdList.class);
		ArrayList<Long> roles = new ArrayList<>();
		for (int i = 0; i < roleIds.size(); i++) {
			roles.add(roleIds.get(i).getPkRoleRoleId());
		}
		List<PermissionIdList> rolePermission = this.rolePermissionRepository.findPkPermissionByPkRoleRoleIdIn(roles,
				PermissionIdList.class);

		ArrayList<String> permission = new ArrayList<>();

		for (PermissionIdList element : rolePermission) {
			permission.add(element.getPkPermissionActionName());
		}
		return permission;
	}

	@Override
	public Page<IListRoleDto> getAllRolePermission(String search, String pageNumber, String pageSize) {

		Pageable pagable = new Pagination().getPagination(pageNumber, pageSize);
		if ((search == "") || (search == null) || (search.length() == 0)) {
			return rolePermissionRepository.findAll(pagable, IListRoleDto.class);
		}

		return null;

	}

}

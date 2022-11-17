package com.martweb.ticketful.api.services;

import com.martweb.ticketful.api.dtos.CreateRoleRequest;
import com.martweb.ticketful.api.dtos.UpdateRoleRequest;
import com.martweb.ticketful.api.entities.Role;
import com.martweb.ticketful.api.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
        //return roles;
    }

    public Role createNewRole(CreateRoleRequest createRoleRequest){
        var getRole = roleRepository.findByName(createRoleRequest.getName());
        getRole.ifPresent(role -> {
            //throw new DuplicateKeyException("The role already exists");
            System.out.println("The role already exists");
        });
        var newRole = new Role();
        newRole.setName(createRoleRequest.getName());
        newRole.setDescription(createRoleRequest.getDescription());
        roleRepository.save(newRole);
        return newRole;
    }

    public Optional<Role> getRoleById(Long id){
        var role =roleRepository.findById(id);
                if(role.isEmpty()){
                    System.out.println("Role not found");
                }
                return role;
    }

    public Optional<Role> updateRole(Long id, UpdateRoleRequest updateRoleRequest){
        var getRole = roleRepository.findById(id);
        var getRoleName = roleRepository.findByName(updateRoleRequest.getName());
        getRoleName.ifPresent(role->{
            System.out.println("The role already exists");
        });
        getRole.ifPresentOrElse(role->{
            role.setName(updateRoleRequest.getName());
            role.setDescription(updateRoleRequest.getDescription());
            roleRepository.save(role);

        },()->{
            System.out.println("Role doesn't exist");
        });
        return getRole;
    }
    public HashMap<Object, Object> deleteRole(Long id){
        var validate = new HashMap<>();
        var role = roleRepository.findById(id);
        role.ifPresentOrElse(r -> {
            roleRepository.delete(r);
            validate.put("Message","Role deleted successfully");
        },()->{
            System.out.println("Rple not found");
        });

        return validate;
    }
}

package com.martweb.ticketful.api.controllers;

import com.martweb.ticketful.api.dtos.CreateRoleRequest;
import com.martweb.ticketful.api.dtos.UpdateRoleRequest;
import com.martweb.ticketful.api.entities.Role;
import com.martweb.ticketful.api.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        var roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        var role = roleService.getRoleById(id);
        return ResponseEntity.of(role);
    }
    @PostMapping("/create")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createNewRole(@Valid @RequestBody CreateRoleRequest createRoleRequest){
        var newRole = roleService.createNewRole(createRoleRequest);
        return ResponseEntity.status(201).body(newRole);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @Valid @RequestBody UpdateRoleRequest updateRoleRequest){
        var role = roleService.updateRole(id,updateRoleRequest);
        return ResponseEntity.of(role);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<Object,Object>> deleteRole(@PathVariable Long id){
        var validate = roleService.deleteRole(id);
        return ResponseEntity.ok(validate);
    }
}

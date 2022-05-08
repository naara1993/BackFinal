
package com.example.demo4.security.service;


import com.example.demo4.security.enums.RolNombre;
import com.example.demo4.security.models.Rol;
import com.example.demo4.security.repository.RolRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}

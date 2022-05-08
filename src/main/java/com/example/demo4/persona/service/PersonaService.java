
package com.example.demo4.persona.service;


import com.example.demo4.persona.models.DatosPersona;
import com.example.demo4.persona.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

  
    @Autowired
    PersonaRepository personaRepository;
    
    
      public PersonaService() {
    }
    
    
    //listar personas
    
     public List<DatosPersona> list(){
        return personaRepository.findAll();
    }
     
        public Optional<DatosPersona> getOne(int id){
        return personaRepository.findById(id);
    }

    
    //guardar persona
      public void  save(DatosPersona persona){
     
        personaRepository.save(persona);
    }

      
      //borrar por id
    public void delete(int id){
        personaRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

    public void save(String nombreCompleto, String domicilio, String profesion) {
      DatosPersona persona = new DatosPersona(nombreCompleto,domicilio,profesion);
      personaRepository.save(persona);
      
    }

    
    

    
}

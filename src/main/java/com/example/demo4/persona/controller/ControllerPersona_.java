
package com.example.demo4.persona.controller;

import com.example.demo4.persona.dto.DatosPersonaDTO;
import com.example.demo4.persona.models.DatosPersona;
import com.example.demo4.persona.service.PersonaService;
import com.example.demo4.security.dto.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")
public class ControllerPersona_ {
   
    
   @Autowired
   PersonaService  personaService;
   
   //crear persona
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody DatosPersonaDTO persona){
           if(persona.getNombreCompleto()==null || persona.getNombreCompleto()==""){
                   return new ResponseEntity(new Mensaje("el nombre no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getDomicilio()==null || persona.getDomicilio()==""){
                   return new ResponseEntity(new Mensaje("el domicilio no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }if(persona.getProfesion()==null || persona.getProfesion()==""){
                   return new ResponseEntity(new Mensaje("la profesion no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
          DatosPersona pers = new DatosPersona (persona.getNombreCompleto(),persona.getDomicilio()
          ,persona.getProfesion()); 
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("persona creada"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<DatosPersona>> list(){
        List<DatosPersona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<DatosPersona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        DatosPersona persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    
    
    //eliminar por id
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }
    
    //actualizar persona
    
    
        @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DatosPersonaDTO personaDTO){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
             if(personaDTO.getNombreCompleto()==null || personaDTO.getNombreCompleto()==""){
               return new ResponseEntity(new Mensaje("el nombre no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(personaDTO.getDomicilio()==null || personaDTO.getDomicilio()==""){
                   return new ResponseEntity(new Mensaje("el domicilio no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }if(personaDTO.getProfesion()==null || personaDTO.getProfesion()==""){
                   return new ResponseEntity(new Mensaje("la profesion no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
        
        DatosPersona persona = personaService.getOne(id).get();
        persona.setNombreCompleto(personaDTO.getNombreCompleto());
        persona.setDomicilio(personaDTO.getDomicilio());
        persona.setProfesion(personaDTO.getProfesion());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
    }
    
}

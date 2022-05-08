
package com.example.demo4.sobreMi.controller;

import com.example.demo4.persona.dto.DatosPersonaDTO;
import com.example.demo4.persona.models.DatosPersona;
import com.example.demo4.persona.service.PersonaService;
import com.example.demo4.security.dto.Mensaje;
import com.example.demo4.sobreMi.dto.SobreMiDTO;
import com.example.demo4.sobreMi.models.SobreMi;
import com.example.demo4.sobreMi.service.sobreMiService;
import java.util.List;
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
@RequestMapping("/sobreMi")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")
public class ControllerSobreMi {
   
   @Autowired
   sobreMiService  personaService;
   
   //crear persona
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody SobreMiDTO persona){
           if(persona.getCadena()==null || persona.getCadena()==""){
                   return new ResponseEntity(new Mensaje("la cadena no puede estar vacia"), HttpStatus.BAD_REQUEST);
          }
           SobreMi pers = new SobreMi (persona.getCadena()); 
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("cadena creada"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<SobreMi>> list(){
        List<SobreMi> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<DatosPersona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SobreMi persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    
    
    //eliminar por id
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("cadena eliminada"), HttpStatus.OK);
    }
    
    //actualizar persona
    
    
        @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody SobreMiDTO personaDTO){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
             if(personaDTO.getCadena()==null || personaDTO.getCadena()==""){
               return new ResponseEntity(new Mensaje("la cadena no puede estar vacia"), HttpStatus.BAD_REQUEST);
          }
        SobreMi persona = personaService.getOne(id).get();
        persona.setCadena(personaDTO.getCadena());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("cadena actualizada"), HttpStatus.OK);
    }
    
    
}

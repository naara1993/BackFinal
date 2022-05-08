
package com.example.demo4.proyectos.controller;


import com.example.demo4.proyectos.dto.ProyectosRealizadosDTO;
import com.example.demo4.proyectos.models.ProyectosRealizados;
import com.example.demo4.proyectos.service.ProyectoService;
import com.example.demo4.security.dto.Mensaje;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")

public class ProyectosRealizadosController {

   @Autowired
   ProyectoService  personaService;
   
   //crear 
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody ProyectosRealizadosDTO persona){
           if(persona.getNombreProyecto()==null || persona.getNombreProyecto()==""){
                   return new ResponseEntity(new Mensaje("el nombre del proyecto no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getDescripcionProyecto()==null || persona.getDescripcionProyecto()==""){
                   return new ResponseEntity(new Mensaje("la descripcion del proyecto no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          ProyectosRealizados pers = new ProyectosRealizados (persona.getNombreProyecto(),persona.getDescripcionProyecto());  
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<ProyectosRealizados>> list(){
        List<ProyectosRealizados> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<ProyectosRealizados> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ProyectosRealizados persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
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
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectosRealizadosDTO personaDTO){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
             if(personaDTO.getNombreProyecto()==null || personaDTO.getNombreProyecto()==""){
               return new ResponseEntity(new Mensaje("el nombre del proyecto no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(personaDTO.getDescripcionProyecto()==null || personaDTO.getDescripcionProyecto()==""){
                   return new ResponseEntity(new Mensaje("la descripcion del proyecto no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
        
        ProyectosRealizados persona = personaService.getOne(id).get();
        persona.setNombreProyecto(personaDTO.getNombreProyecto());
        persona.setDescripcionProyecto(personaDTO.getDescripcionProyecto());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("proyecto actualizado"), HttpStatus.OK);
    }
    
}


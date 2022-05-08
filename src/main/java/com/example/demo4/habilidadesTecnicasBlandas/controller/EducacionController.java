
package com.example.demo4.habilidadesTecnicasBlandas.controller;
import com.example.demo4.habilidadesTecnicasBlandas.dto.EducacionDTO;
import com.example.demo4.habilidadesTecnicasBlandas.models.Educacion;
import com.example.demo4.habilidadesTecnicasBlandas.service.EducacionService;
import com.example.demo4.persona.dto.DatosPersonaDTO;
import com.example.demo4.persona.models.DatosPersona;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")

public class EducacionController {
    
   @Autowired
   EducacionService  personaService;
   
   //crear persona
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody EducacionDTO persona){
           if(persona.getEscuela()==null || persona.getEscuela()==""){
                   return new ResponseEntity(new Mensaje("el nombre de la escuela no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getTitulo()==null || persona.getTitulo()==""){
                   return new ResponseEntity(new Mensaje("el titulo no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_inicio()==null || persona.getFecha_inicio()==""){
                   return new ResponseEntity(new Mensaje("la fecha inicio  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_final()==null || persona.getFecha_final()==""){
                   return new ResponseEntity(new Mensaje("la fecha  final   no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
        
          Educacion pers = new Educacion (persona.getEscuela(),persona.getTitulo()
          ,persona.getFecha_inicio(),persona.getFecha_final(),persona.getImagen()); 
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("educacion creada"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<DatosPersona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    
    
    //eliminar por id
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("educacion  eliminado"), HttpStatus.OK);
    }
    
    //actualizar persona
    
    
        @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EducacionDTO persona){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
         if(persona.getEscuela()==null || persona.getEscuela()==""){
                   return new ResponseEntity(new Mensaje("el nombre de la escuela no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getTitulo()==null || persona.getTitulo()==""){
                   return new ResponseEntity(new Mensaje("el titulo no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_inicio()==null || persona.getFecha_inicio()==""){
                   return new ResponseEntity(new Mensaje("la fecha inicio  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_final()==null || persona.getFecha_final()==""){
                   return new ResponseEntity(new Mensaje("la fecha  final   no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
          
        Educacion per = personaService.getOne(id).get();
        per.setEscuela(persona.getEscuela());
        per.setTitulo(persona.getTitulo());
        per.setFecha_inicio(persona.getFecha_inicio());
        per.setFecha_final(persona.getFecha_final());
        per.setImagen(persona.getImagen());
        personaService.save(per);
        return new ResponseEntity(new Mensaje("Datos de educacion actualizados"), HttpStatus.OK);
    }
    
    
    
    
    
}

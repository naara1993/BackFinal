
package com.example.demo4.seccionHabilidadesBlandas.controller;

import com.example.demo4.seccionHabilidadesBlandas.dto.HabilidadesBlandasDTO;
import com.example.demo4.seccionHabilidadesBlandas.models.HabilidadesBlandas;
import com.example.demo4.seccionHabilidadesBlandas.service.HabilidadesBlandasService;
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
@RequestMapping("/blandas")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")
public class HabilidadesBlandasController {
 
    
        
   @Autowired
   HabilidadesBlandasService  personaService;
   
   //crear 
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody HabilidadesBlandasDTO persona){
               if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }     if(persona.getNombre()==null || persona.getNombre()==""){
                   return new ResponseEntity(new Mensaje("el nombre no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
        
          HabilidadesBlandas pers = new HabilidadesBlandas (persona.getImagen(),persona.getNombre()); 
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("habilidad blanda creada"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesBlandas>> list(){
        List<HabilidadesBlandas> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesBlandas> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HabilidadesBlandas persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
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
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody HabilidadesBlandasDTO persona){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
              if(persona.getNombre()==null || persona.getNombre()==""){
                   return new ResponseEntity(new Mensaje("el nombre  no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          
        HabilidadesBlandas per = personaService.getOne(id).get();
        per.setImagen(persona.getImagen());
        per.setNombre(persona.getNombre());
        personaService.save(per);
        return new ResponseEntity(new Mensaje("Datos de la habilidad Tecnica actualizados"), HttpStatus.OK);
    }
       
    
    
}

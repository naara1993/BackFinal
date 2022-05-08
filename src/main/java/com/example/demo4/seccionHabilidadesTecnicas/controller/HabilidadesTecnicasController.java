
package com.example.demo4.seccionHabilidadesTecnicas.controller;


import com.example.demo4.seccionHabilidadesTecnicas.dto.HabilidadesTecnicasDTO;
import com.example.demo4.seccionHabilidadesTecnicas.models.HabilidadesTecnicas;
import com.example.demo4.seccionHabilidadesTecnicas.service.HabilidadesTecnicasService;
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
@RequestMapping("/tecnicas")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")
public class HabilidadesTecnicasController {
        
   @Autowired
   HabilidadesTecnicasService  personaService;
   
   //crear persona
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody HabilidadesTecnicasDTO persona){
               if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
        
          HabilidadesTecnicas pers = new HabilidadesTecnicas (persona.getImagen()); 
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("habilidad tecnica creada"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesTecnicas>> list(){
        List<HabilidadesTecnicas> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<HabilidadesTecnicas> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HabilidadesTecnicas persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
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
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody HabilidadesTecnicasDTO persona){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
          
        HabilidadesTecnicas per = personaService.getOne(id).get();
        per.setImagen(persona.getImagen());
        personaService.save(per);
        return new ResponseEntity(new Mensaje("Datos de la habilidad Tecnica actualizados"), HttpStatus.OK);
    }
       
}

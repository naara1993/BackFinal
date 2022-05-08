
package com.example.demo4.habilidadesTecnicasBlandas.controller;
import com.example.demo4.habilidadesTecnicasBlandas.dto.ExperienciaDTO;
import com.example.demo4.habilidadesTecnicasBlandas.models.Experiencia;
import com.example.demo4.habilidadesTecnicasBlandas.service.ExperienciaService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://hostingangularargentina.web.app")
public class ExperienciaController {


   @Autowired
   ExperienciaService  personaService;
   
   //crear persona
         @PreAuthorize("hasRole('ADMIN')")
         @PostMapping("/crear")
      public ResponseEntity<?>   create(@RequestBody ExperienciaDTO persona){
           if(persona.getEmpresa()==null || persona.getEmpresa()==""){
                   return new ResponseEntity(new Mensaje("el nombre de la empresa no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getPuesto()==null || persona.getPuesto()==""){
                   return new ResponseEntity(new Mensaje("el puesto no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_inicio()==null || persona.getFecha_inicio()==""){
                   return new ResponseEntity(new Mensaje("la fecha inicio  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_final()==null || persona.getFecha_final()==""){
                   return new ResponseEntity(new Mensaje("la fecha  final   no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getDescripcion()==null || persona.getDescripcion()==""){
                   return new ResponseEntity(new Mensaje("la descripcion  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
        
          Experiencia pers = new Experiencia (persona.getEmpresa(),persona.getPuesto()
          ,persona.getFecha_inicio(),persona.getFecha_final(),persona.getDescripcion(),persona.getImagen()); 
          personaService.save(pers);
          return new ResponseEntity(new Mensaje("experiencia creada"), HttpStatus.OK);          
      }
      
      
      //mostrar lista
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
      
    //mostrar por id
   
    @GetMapping("/detail/{id}")
    public ResponseEntity<DatosPersona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))  // si no existe el id
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia persona = personaService.getOne(id).get();  //mostrar datos de una sola persona
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
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienciaDTO persona){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
              if(persona.getEmpresa()==null || persona.getEmpresa()==""){
                   return new ResponseEntity(new Mensaje("el nombre de la empresa no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getPuesto()==null || persona.getPuesto()==""){
                   return new ResponseEntity(new Mensaje("el puesto no debe estar vacio"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_inicio()==null || persona.getFecha_inicio()==""){
                   return new ResponseEntity(new Mensaje("la fecha inicio  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getFecha_final()==null || persona.getFecha_final()==""){
                   return new ResponseEntity(new Mensaje("la fecha  final   no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }if(persona.getDescripcion()==null || persona.getDescripcion()==""){
                   return new ResponseEntity(new Mensaje("la descripcion  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
          if(persona.getImagen()==null || persona.getImagen()==""){
                   return new ResponseEntity(new Mensaje("la imagen  no debe estar vacia"), HttpStatus.BAD_REQUEST);
          }
        Experiencia per = personaService.getOne(id).get();
        per.setEmpresa(persona.getEmpresa());
        per.setPuesto(persona.getPuesto());
        per.setFecha_inicio(persona.getFecha_inicio());
        per.setFecha_final(persona.getFecha_final());
        per.setDescripcion(persona.getDescripcion());
        per.setImagen(persona.getImagen());
        personaService.save(per);
        return new ResponseEntity(new Mensaje("Datos de educacion actualizados"), HttpStatus.OK);
    }
    



    
}

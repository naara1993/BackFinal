
package com.example.demo4.proyectos.service;

import com.example.demo4.persona.models.DatosPersona;
import com.example.demo4.proyectos.models.ProyectosRealizados;
import com.example.demo4.proyectos.repository.ProyectosRealizadosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectoService {
    
     @Autowired
    ProyectosRealizadosRepository personaRepository;
    
       public ProyectoService() {
    }
    
    
    //listar personas
    
     public List<ProyectosRealizados> list(){
        return personaRepository.findAll();
    }
     
        public Optional<ProyectosRealizados> getOne(int id){
        return personaRepository.findById(id);
    }

    
    //guardar persona
      public void  save(ProyectosRealizados proyectos){
     
        personaRepository.save(proyectos);
    }

      
      //borrar por id
    public void delete(int id){
        personaRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

    public void save(String nombreProyecto, String descripcionProyecto) {
      ProyectosRealizados proyectos = new ProyectosRealizados(nombreProyecto,descripcionProyecto);
      personaRepository.save(proyectos);
      
    }

    
    
    
}

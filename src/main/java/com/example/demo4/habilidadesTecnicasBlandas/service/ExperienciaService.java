
package com.example.demo4.habilidadesTecnicasBlandas.service;

import com.example.demo4.habilidadesTecnicasBlandas.models.Experiencia;
import com.example.demo4.habilidadesTecnicasBlandas.repositroy.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {

    
      @Autowired
      ExperienciaRepository experienciaRepository;

    public ExperienciaService() {
    }
      
     //listar 
    
     public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }
     
        public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }

    
    //guardar persona
      public void  save(Experiencia experiencia){
     
        experienciaRepository.save(experiencia);
    }

      
      //borrar por id
    public void delete(int id){
        experienciaRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }

    public void save(String puesto,String empresa, String fecha_inicio,String fecha_final,String descripcion,String imagen) {
      Experiencia exp = new Experiencia(puesto,empresa,fecha_inicio,fecha_final,descripcion,imagen);
      experienciaRepository.save(exp);
      
    }
}

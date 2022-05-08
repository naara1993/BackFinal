
package com.example.demo4.habilidadesTecnicasBlandas.service;

import com.example.demo4.habilidadesTecnicasBlandas.models.Educacion;
import com.example.demo4.habilidadesTecnicasBlandas.repositroy.EscuelaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    
      @Autowired
      EscuelaRepository escuelaRepository;

    public EducacionService() {
    }
      
     //listar 
    
     public List<Educacion> list(){
        return escuelaRepository.findAll();
    }
     
        public Optional<Educacion> getOne(int id){
        return escuelaRepository.findById(id);
    }

    
    //guardar persona
      public void  save(Educacion escuela){
     
        escuelaRepository.save(escuela);
    }

      
      //borrar por id
    public void delete(int id){
        escuelaRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return escuelaRepository.existsById(id);
    }

    public void save(String escuela,String titulo, String fecha_inicio,String fecha_final,String imagen) {
      Educacion esc = new Educacion(escuela,titulo,fecha_inicio,fecha_final,imagen);
      escuelaRepository.save(esc);
      
    }

    
   
    
    
}

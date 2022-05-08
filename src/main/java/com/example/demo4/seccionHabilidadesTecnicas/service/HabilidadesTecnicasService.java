
package com.example.demo4.seccionHabilidadesTecnicas.service;

import com.example.demo4.seccionHabilidadesTecnicas.models.HabilidadesTecnicas;
import com.example.demo4.seccionHabilidadesTecnicas.repository.HabilidadesTecnicasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HabilidadesTecnicasService {
    
     @Autowired
     HabilidadesTecnicasRepository habilidadesRepository;

    public HabilidadesTecnicasService() {
    }
    
    //listar 
    
     public List<HabilidadesTecnicas> list(){
        return habilidadesRepository.findAll();
    }
     
        public Optional<HabilidadesTecnicas> getOne(int id){
        return habilidadesRepository.findById(id);
    }

    
    //guardar persona
      public void  save(HabilidadesTecnicas habilidadesTecnicas){
     
        habilidadesRepository.save(habilidadesTecnicas);
    }

      
      //borrar por id
    public void delete(int id){
        habilidadesRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return habilidadesRepository.existsById(id);
    }

    public void save(String imagen) {
      HabilidadesTecnicas esc = new HabilidadesTecnicas(imagen);
      habilidadesRepository.save(esc);
      
    }

    
   
}

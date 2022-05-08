
package com.example.demo4.seccionHabilidadesBlandas.service;

import com.example.demo4.seccionHabilidadesBlandas.models.HabilidadesBlandas;
import com.example.demo4.seccionHabilidadesBlandas.repository.HabilidadesBlandasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HabilidadesBlandasService {
    
    
      @Autowired
      HabilidadesBlandasRepository  blandasRepository;
      
      
       public HabilidadesBlandasService() {
    }
    
    //listar 
    
     public List<HabilidadesBlandas> list(){
        return blandasRepository.findAll();
    }
     
        public Optional<HabilidadesBlandas> getOne(int id){
        return blandasRepository.findById(id);
    }

    
    //guardar persona
      public void  save(HabilidadesBlandas habilidadesBlandas){
     
        blandasRepository.save(habilidadesBlandas);
    }

      
      //borrar por id
    public void delete(int id){
        blandasRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return blandasRepository.existsById(id);
    }
    public void save(String imagen,String nombre) {
      HabilidadesBlandas esc = new HabilidadesBlandas(imagen,nombre);
      blandasRepository.save(esc);
      
    }

    
      
    
}

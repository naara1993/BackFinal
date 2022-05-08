
package com.example.demo4.sobreMi.service;

import com.example.demo4.sobreMi.models.SobreMi;
import com.example.demo4.sobreMi.repository.SobreMiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class sobreMiService {
    
    
     @Autowired
     SobreMiRepository sobreMiRepository;

    public sobreMiService() {
    }
     
   //listar 
    
     public List<SobreMi> list(){
        return sobreMiRepository.findAll();
    }
     
        public Optional<SobreMi> getOne(int id){
        return sobreMiRepository.findById(id);
    }

    
    //guardar persona
      public void  save(SobreMi persona){
     
        sobreMiRepository.save(persona);
    }

      
      //borrar por id
    public void delete(int id){
        sobreMiRepository.deleteById(id);
    }

    //si existe por id
    
    public boolean existsById(int id){
        return sobreMiRepository.existsById(id);
    }

    public void save(String cadena) {
      SobreMi persona = new SobreMi(cadena);
      sobreMiRepository.save(persona);
      
    }

    
   
    
}

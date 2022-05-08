
package com.example.demo4.habilidadesTecnicasBlandas.repositroy;

import com.example.demo4.habilidadesTecnicasBlandas.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExperienciaRepository  extends JpaRepository<Experiencia, Integer>{
    
}

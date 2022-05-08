
package com.example.demo4.seccionHabilidadesBlandas.repository;

import com.example.demo4.seccionHabilidadesBlandas.models.HabilidadesBlandas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesBlandasRepository extends JpaRepository<HabilidadesBlandas, Integer> {
    
}

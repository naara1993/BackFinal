
package com.example.demo4.seccionHabilidadesTecnicas.repository;

import com.example.demo4.seccionHabilidadesTecnicas.models.HabilidadesTecnicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesTecnicasRepository extends JpaRepository<HabilidadesTecnicas, Integer> {
    
}


package com.example.demo4.proyectos.repository;

import com.example.demo4.proyectos.models.ProyectosRealizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProyectosRealizadosRepository   extends JpaRepository<ProyectosRealizados, Integer>{
    
}

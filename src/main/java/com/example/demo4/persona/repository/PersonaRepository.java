
package com.example.demo4.persona.repository;

import com.example.demo4.persona.models.DatosPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<DatosPersona, Integer>{   
}

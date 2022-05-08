
package com.example.demo4.sobreMi.repository;


import com.example.demo4.sobreMi.models.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreMiRepository extends JpaRepository<SobreMi, Integer> {
    
}

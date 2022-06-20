package com.ipiecoles.java.java350.repository;


import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootTest //charge context spring

public class EmployeRepositoryTest {
    @Autowired
    EmployeRepository employeRepository;
    @AfterEach
    @BeforeEach
    public void purge(){
        employeRepository.deleteAll();
    }
    @Test
    public void testFindLastMatriculeWithoutEmploye(){
        //Given
        employeRepository.deleteAll();
        //When
        String matricule = employeRepository.findLastMatricule();

        //Then
        Assertions.assertThat(matricule).isNull();
    }

    @Test
    public void testFindLastMatriculeWithEmploye(){
        //Given
        employeRepository.deleteAll();
        Employe employe1 = new Employe("Jhon","Daniel","M14575", LocalDate.now(),2500d,1,1.0);
        Employe employe2 = new Employe("Jhon","Daniel","J14545", LocalDate.now(),2500d,1,1.0);
        Employe employe3 = new Employe("Jhon","Daniel","C14175", LocalDate.now(),2500d,1,1.0);
        employeRepository.saveAll(Arrays.asList(employe1,employe2,employe3));

        //When
        String matricule = employeRepository.findLastMatricule();

        //Then
        Assertions.assertThat(matricule).isEqualTo("14575");
    }
}

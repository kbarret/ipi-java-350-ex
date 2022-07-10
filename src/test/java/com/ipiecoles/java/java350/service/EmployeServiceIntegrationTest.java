package com.ipiecoles.java.java350.service;

import com.ipiecoles.java.java350.exception.EmployeException;
import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.model.Entreprise;
import com.ipiecoles.java.java350.model.NiveauEtude;
import com.ipiecoles.java.java350.model.Poste;
import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EmployeServiceIntegrationTest {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private EmployeRepository employeRepository;

    @AfterEach
    @BeforeEach
    public void purge(){
        employeRepository.deleteAll();
    }
    @Test
    public void testEmbaucheemploye() throws EmployeException {
        //Given
        //When
        employeService.embaucheEmploye("Doe","jhon", Poste.COMMERCIAL, NiveauEtude.MASTER,1.0);
        //then
        Employe employe = employeRepository.findByMatricule("C00001");
        Assertions.assertThat(employe.getNom()).isEqualTo("Doe");
        Assertions.assertThat(employe.getPrenom()).isEqualTo("jhon");
        Assertions.assertThat(employe.getDateEmbauche()).isEqualTo(LocalDate.now());
        Assertions.assertThat(employe.getPerformance()).isEqualTo(Entreprise.PERFORMANCE_BASE);
        Assertions.assertThat(employe.getSalaire()).isEqualTo(2129.71);
        Assertions.assertThat(employe.getTempsPartiel()).isEqualTo(1);
    }

    @Test
    public void testCalculPerformanceCommerciale() throws EmployeException {
        //Given
        //When
        employeService.embaucheEmploye("Doe","jhon", Poste.COMMERCIAL, NiveauEtude.MASTER,1.0);
        employeService.calculPerformanceCommercial("C00001",100000L,100000L);
        //then
        Employe employe = employeRepository.findByMatricule("C00001");
        Assertions.assertThat(employe.getPerformance()).isEqualTo(2);

    }

    @Test
    public void testavgPerformanceWhereMatriculeStartsWith() throws EmployeException {
        //Given
        //When
        employeService.embaucheEmploye("Doe","jhon", Poste.COMMERCIAL, NiveauEtude.MASTER,1.0);
        //then
        Assertions.assertThat(employeRepository.avgPerformanceWhereMatriculeStartsWith("C")).isEqualTo(1);

    }

}

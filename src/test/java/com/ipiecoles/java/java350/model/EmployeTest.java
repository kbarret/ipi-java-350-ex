package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void testGetNbAnneeAnciennete(){
        //given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now());

        //when
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isZero();
    }

    @Test
    public void testGetNbAnneesAncienneteDateEmbauchePassee(){
        //given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(10));

        //when
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(10);

    }

    @Test
    public void testGetNbAnneesAncienneteDateEmbaucheFuture(){
        //given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().plusYears(2));

        //when
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isZero();

    }

    @Test
    public void testGetNbAnneesAncienneteDateEmbaucheNull(){
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(null);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then        // => 0
        Assertions.assertThat(nbAnneesAnciennete).isZero();
    }

//    @ParameterizedTest
//    @CsvSource({
//            "'M12345',0,1,1,0, 1700.0",
//            "'T12345',0,1,1,0, 1000.0"
//    })
//    public void testGetPrimeAnuelleManagerPerformanceBasePleinTemps(
//            String matricule,
//            Integer nbAnneesAnciennete,
//            Integer performance,
//            Double tauxActivite,
//            Double prime
//    ){
//        //Given
//        Employe employe = new Employe("Doe", "Jhon", matricule, LocalDate.now().minusYears(nbAnneesAnciennete), 2500d,performance,tauxActivite);
//        employe.setDateEmbauche(null);
//
//        //When
//        Double primeObtenue = employe.getPrimeAnnuelle();
//
//        //Then        // => 0
//        Assertions.assertThat(primeObtenue).isEqualTo(prime);
//    }

    @ParameterizedTest
    @CsvSource({
            "'M12345',0,1,1.0,1700.0",
            "'T12346',0,1,1.0,1000.0",
            "'T12346',0,2,1.0,2300.0"
    })
    public void testGetPrimeAnnuelleManagerPerformanceBasePleinTemps(
            String matricule,
            Integer nbAnneesAnciennete,
            Integer performance,
            Double tauxActivite,
            Double prime    ){
        //Given
        Employe employe = new Employe("Doe", "John", matricule,
                                        LocalDate.now().minusYears(nbAnneesAnciennete), 2500d, performance, tauxActivite);
        //When
        Double primeObtenue = employe.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(primeObtenue).isEqualTo(prime);
    }
}

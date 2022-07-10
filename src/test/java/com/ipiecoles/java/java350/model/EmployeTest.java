package com.ipiecoles.java.java350.model;

import com.ipiecoles.java.java350.exception.EmployeException;
import io.cucumber.java8.Da;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

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
            "'M12345',2,1,1.0,1900.0",
            "'M12345',0,1,0.5,850.0",
            "'T12346',5,1,1.0,1500.0",
            "'T12346',3,2,1.0,2600.0",
            "'T12346',0,1,1.0,1000.0",
            "'T12346',0,2,1.0,2300.0",
            ",0,1,1.0,1000.0",
            "'T12346',0,,1.0,1000.0"
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
    @Test
    public void testAgmenterSalaire(){
        //Given
        Employe employe = new Employe();
        employe.setSalaire(1521.22);

        //When
        Double Salaire = employe.augmenterSalaire(10.0);

        //Then        // => 0
        Assertions.assertThat(Salaire).isEqualTo(1673.342);

    }

    @Test
    public void testAgmenterSalaireDiminuer(){
        //Given 1521.22
        Employe employe = new Employe();
        employe.setSalaire(1521.22);

        //When
        Double Salaire = employe.augmenterSalaire(-10.0);

        //Then        // => 0
        Assertions.assertThat(Salaire).isEqualTo(1521.22);

    }

    @Test
    public void testAgmenterSalaireEgal(){
        //Given 1521.22
        Employe employe = new Employe();
        employe.setSalaire(1521.22);

        //When
        Double Salaire = employe.augmenterSalaire(0.0);

        //Then        // => 0
        Assertions.assertThat(Salaire).isEqualTo(1521.22);
    }

    @ParameterizedTest
    @CsvSource({
            "2019,8",
            "2021,10",
            "2022,10",
            "2032,11"
    })
    //@Test
    public void testGetNbRtt(
        int annee,
        Integer rtt
        ){
        //Given
        Employe employe = new Employe("Doe", "John", "T12345",
                LocalDate.now().minusYears(5), 2500d,1, 1.0);
        //When
        Integer rttObtenue = employe.getNbRtt(LocalDate.of(annee, 1, 1));
        //Then
        Assertions.assertThat(rttObtenue).isEqualTo(rtt);
    }
}

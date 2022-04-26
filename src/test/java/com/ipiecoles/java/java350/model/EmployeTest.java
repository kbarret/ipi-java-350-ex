package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}

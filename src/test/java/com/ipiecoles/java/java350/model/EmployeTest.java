package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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


    }

    @Test
    public void testGetNbAnneesAncienneteDateEmbaucheFuture(){


    }
}

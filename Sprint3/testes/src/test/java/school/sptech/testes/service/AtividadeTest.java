package school.sptech.testes.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    @Test
    @DisplayName("é palindrome")
    void ehPalindorme(){
        //Assert
        var valor = "arara";
        Atividade atividade = new Atividade();

        //act
        boolean resultado = atividade.isPalindrome(valor);

        //assert
        assertTrue(resultado);
    }


}
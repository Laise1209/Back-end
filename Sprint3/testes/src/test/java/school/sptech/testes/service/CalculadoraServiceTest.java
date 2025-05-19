package school.sptech.testes.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("Somar dois números 2 e o resultado da soma tem q ser 4")
    void somarValoresValidosCorretamente() {
        //Arrange
        var valor1 = 2.0;
        var valor2 = 2.0;
        var resultadoEsperado = 4.0;
        CalculadoraService service = new CalculadoraService();

        //Act
        Double resposta = service.somar(valor1, valor2);

        //Assert
        assertEquals(resultadoEsperado, resposta);
    }

    @Test
    @DisplayName("Somar 6 com 6 :D")
    void somarSeisComSeis(){
        //Arrange
        var valor1 = 6.0;
        var valor2 = 6.0;
        var resultadoEsperado = 12.0;
        CalculadoraService service = new CalculadoraService();

        //Act
        Double resposta = service.somar(valor1, valor2);

        //Assert
        assertEquals(resultadoEsperado, resposta);
    }

    @Test
    @DisplayName("nao pode somar com nulo, zé")
    void somarComNuloDeveDarException(){
        //Arrange
        var valor1 = 2.0;
        Double valor2 = null;
        var textoEsperado = "nao pode prç";
        CalculadoraService service = new CalculadoraService();

        //Act
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> service.somar(valor1, valor2));

        //Assert
        assertEquals(textoEsperado, exception.getMessage());

    }
}
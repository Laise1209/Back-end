package school.sptech.testes.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.testes.entity.Empresa;
import school.sptech.testes.exception.EntidadeNaoEncontradaException;
import school.sptech.testes.repository.EmpresaRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {
    @InjectMocks
    private EmpresaService service;
    @Mock
    private EmpresaRepository repository;

    /*
    * TODO (listagem):
    *  -Retorna empresas
    *  -Não retorna empresas
    */

    @Test
    @DisplayName("Listagem quando acionado deve retornar empresas")
    void listagemDeveRetornarEmpresasTest(){
        //BDD - Behavior driven design
        //Given, When Then and Assert

        //Given
        List<Empresa> empresas = List.of(
                new Empresa(1L, "Arcos Dourados", "Mc Donalds", "1234567891011"),
                new Empresa( 2l, "Romario", "Armarinhos fernando", "098765432121"),
                new Empresa( 3L, "Mattel", "Mattel", "56789043210987")
        );

        //When
        Mockito.when(repository.findAll()).thenReturn(empresas);

        //Then
        List<Empresa> resposta = service.listagem();

        //Assert
        assertEquals(empresas, resposta.size());
    }

    @Test
    @DisplayName("Listagem quando acionado não deve retornar empresas")
    void listagemNaoDeveRetornarEmpresasTest(){

        //When
        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

        //Then
        List<Empresa> resposta = service.listagem();

        //Assert
        assertTrue(resposta.isEmpty());
    }

    @Test
    @DisplayName("BuscarPorId quando acionado deve retornar a empresa correta")
    void buscarPorIdDeveRetornarEmpresa(){
        //Given
        var empresas = new Empresa(1L, "Arcos Dourados", "Mc Donalds", "1234567891011");

        //When
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(empresas));

        //Then
        Empresa resposta = service.buscarPorId(1L);

        //Assert
        assertEquals(empresas, resposta);
    }

    @Test
    @DisplayName("BuscarPorID quando acionado não deve encontrar a empresa e lançar uma exception")
    void buscarPorIdNaoDeveetornarEmpresa(){
        //Given/When
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        //Then/Assert
        assertThrows(EntidadeNaoEncontradaException.class,
                ()-> service.buscarPorId(1L));
    }

    //Remover por id
    // - Remove empresa do banco
    // - Lança exception

    @Test
    @DisplayName("remover quando acionado com um id válido deve remover a empresa")
    void removerPorIdDeveRemover(){
        //Given
        var idTeste = 3L;

        //When
        Mockito.when(repository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.doNothing().when(repository).deleteById(Mockito.anyLong());

        //Then
        service.remover(idTeste);

        //Assert
        Mockito.verify(repository,Mockito.times(1)).existsById(Mockito.anyLong());
        Mockito.verify(repository,Mockito.times(1)).deleteById(Mockito.anyLong());
    }
}
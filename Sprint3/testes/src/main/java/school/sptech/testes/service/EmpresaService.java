package school.sptech.testes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.testes.entity.Empresa;
import school.sptech.testes.exception.EntidadeNaoEncontradaException;
import school.sptech.testes.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository repository;

//    Listagem -
//    Busca pelo id
//    Cadastro Atualização pelo id
//    Atualoização pelo id
//    Remoção por id

    public List<Empresa> listagem(){
        List<Empresa> todasEmpresas = repository.findAll();
        return todasEmpresas;
    }

    public Empresa buscarPorId(long id){
        Optional<Empresa> byId = repository.findById(id);
        if(byId.isPresent()){
            throw new EntidadeNaoEncontradaException("Empresa nao encontrada");
        }
        return byId.get();
    }

    public void remover(long id){
        if (!repository.existsById(id)){
            throw new EntidadeNaoEncontradaException("Empresa nao encontrada");

        }
        repository.deleteById(id);
    }

}

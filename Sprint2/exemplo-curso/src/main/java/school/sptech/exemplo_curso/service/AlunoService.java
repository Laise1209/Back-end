package school.sptech.exemplo_curso.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_curso.entity.Aluno;
import school.sptech.exemplo_curso.repository.AlunoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository repository;
    public List<Aluno> listar(){
        return repository.findAll();
    }

    public List<Aluno> buscarPorCursoNome(String nomeProcurado){
        return repository.findByCursoNomeContainingIgnoreCase(nomeProcurado);
    }
}

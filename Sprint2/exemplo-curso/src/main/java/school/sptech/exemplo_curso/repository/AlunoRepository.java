package school.sptech.exemplo_curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_curso.entity.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByCursoNomeContainingIgnoreCase(String nomeCurso);

}

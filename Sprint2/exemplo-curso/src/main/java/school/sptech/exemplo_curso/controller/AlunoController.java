package school.sptech.exemplo_curso.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.exemplo_curso.entity.Aluno;
import school.sptech.exemplo_curso.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService service;
    @GetMapping
    public ResponseEntity<List<Aluno>> listar(){
        List alunos = service.listar();
        if(alunos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(alunos);
    }

    @GetMapping("/cursos/nome")
    public ResponseEntity<List<Aluno>> buscarPorNomeCurso(@RequestParam String valor){
        List<Aluno> alunos = service.buscarPorCursoNome(valor);
        if(alunos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(alunos);
    }
}

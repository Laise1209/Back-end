package school.sptech.exemplo_curso.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_curso.dto.CursoAtualizacaoDto;
import school.sptech.exemplo_curso.dto.CursoCadastroDto;
import school.sptech.exemplo_curso.dto.CursoListagemDto;
import school.sptech.exemplo_curso.dto.CursoMapper;
import school.sptech.exemplo_curso.entity.Curso;
import school.sptech.exemplo_curso.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoListagemDto>> listar() {
        List<Curso> cursos = cursoService.listar();

        if (cursos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        List<CursoListagemDto> dtos = CursoMapper.toListagemDtos(cursos);

        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoListagemDto> listarPorId(@PathVariable Integer id) {
        Curso curso = cursoService.buscarPorId(id);
        CursoListagemDto dto = CursoMapper.toListagemDto(curso);
        return ResponseEntity.status(200).body(dto);
    }

    @PostMapping
    public ResponseEntity<CursoListagemDto> cadastrar(@Valid @RequestBody CursoCadastroDto dto) {
        Curso curso = CursoMapper.toEntity(dto);
        Curso cursoSalvo = cursoService.cadastrar(curso);
        CursoListagemDto dtoSalvo = CursoMapper.toListagemDto(cursoSalvo);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoListagemDto> atualizar(@PathVariable Integer id, @Valid @RequestBody CursoAtualizacaoDto dto) {
        Curso curso = CursoMapper.toEntity(dto, id);
        Curso cursoAtualizado = cursoService.atualizar(curso);
        CursoListagemDto dtoAtualizado = CursoMapper.toListagemDto(cursoAtualizado);
        return ResponseEntity.status(200).body(dtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        cursoService.removerPorId(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/media-precos")
    public ResponseEntity<Double> media(){
        return ResponseEntity.status(204).body(cursoService.getMedia());
    }

    @DeleteMapping
    public ResponseEntity<Double> deleteMenorMil(@PathVariable Double valor){
        int linhasRemovidas = cursoService.removerPorMenorPreco(valor);
        return ResponseEntity.status(204).body();
    }
}

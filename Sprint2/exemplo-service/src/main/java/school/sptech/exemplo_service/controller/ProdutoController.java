package school.sptech.exemplo_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_service.entity.Produto;
import school.sptech.exemplo_service.repository.ProdutoRepository;
import school.sptech.exemplo_service.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;


    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        List<Produto> todos = service.listar();
        if(todos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.status(200).body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto){
        Produto produtoRegistrado = service.cadastrar(produto);
        return ResponseEntity.status(201).body(produtoRegistrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        service.remover(id);
        return ResponseEntity.status(204).build();
    }
}

package com.example.exemplo_banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository repository;

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro){
        Livro livroSalvo = repository.save(livro);
        return livroSalvo;
    }

    @GetMapping
    public List<Livro> listar(){
        List<Livro> todos = repository.findAll();
        return todos;
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Integer id){
        Optional<Livro> possivelLivro = repository.findById(id);
         if(possivelLivro.isPresent()){
             return possivelLivro.get();
         }
         return null;
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Integer id, @RequestBody Livro paraAtualizar){
        if(repository.existsById(id)){
            paraAtualizar.setId(id);
            Livro livroAtualizado = repository.save(paraAtualizar);
            return livroAtualizado;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "removido com sucesso";
        }

        return "id não encontrado";
    }

    @GetMapping("/contagem")
    public Long contar(){
        return  repository.count();
    }

}

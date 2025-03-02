package com.example.aula2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //indica que a classe agora é um componente do spring
@RequestMapping("/filmes") //sempre no plurar
public class FilmeController {
    private List <Filme> filmes = new ArrayList<>();

    @PostMapping
    public Filme cadastrar(@RequestBody Filme novoFilme) {
        filmes.add(novoFilme);
        return novoFilme;
    }

    @GetMapping("/listar")
        public List<Filme> listar(){
            return filmes;
        }


    @GetMapping("/{index}")
        public Filme buscar(@PathVariable Integer index){
            if(index >= 0 && index < filmes.size()){
                filmes.get(index);
            }
            return null;
        }


    @PutMapping("/atualizar/{index}/{novoAno}/{novoTitulo}")
        public Filme atualizar(@PathVariable Integer index, @RequestBody Filme filmeParaAtualizar){
//            Filme filme = filmes.get(index);
            filmes.set(index, filmeParaAtualizar);
            return filmeParaAtualizar;
        }


    @GetMapping("/{index}")
        public String deletar(@PathVariable int index){
            filmes.remove(index);
            return "removido com sucesso";
        }


}

package school.sptech.primeira_aula;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @GetMapping("/aleatorio")
    public Filme getFilmeAleatorio(){
        Filme filme = new Filme("Bastardos Inglórios", "Quentin Tarantino");
        return filme;
    }

    private List<Filme> filmes = new ArrayList<>();

    public FilmeController(){
        filmes = new ArrayList<>();
        filmes.add(new Filme("shereq", "Robert Johnson"));
        filmes.add(new Filme("Gabinete de curiosidades", "guilhermo del toro"));
    }

    @GetMapping
    public List<Filme> listar(){
        return filmes;
    }

    @GetMapping("/{nomeFilme}")
        public String buscarFilme(@PathVariable String nomeFilme){
            for (Filme filmeDaVez : filmes) {
                if(filmeDaVez.getNome().equals(nomeFilme)){
                    return "existe";
                }
            }
            return "nao acho";
        }

}

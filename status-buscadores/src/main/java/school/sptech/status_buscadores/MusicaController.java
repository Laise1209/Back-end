package school.sptech.status_buscadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired //Serve para delegar para o spring injetar
    private MusicaRepository repository;

    @PostMapping
    public ResponseEntity<Musica> cadastrar(@RequestBody Musica musica){
        Musica musicaRegistrada = repository.save(musica);
        return ResponseEntity.status(201).body(musicaRegistrada);
//        ResponseEntity.created(); -> É igual o de cima, valida se criou no protocolo HTTP
    }

    @GetMapping
    public ResponseEntity<List<Musica>> listar(){
//        return repository.findAll();
        List<Musica> todasMusicas = repository.findAll();

        if(todasMusicas.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(todasMusicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable Integer id){
        Optional<Musica> possivelMusica = repository.findById(id);

        return ResponseEntity.of(repository.findById(id));

        //Os dois fazem a mesma coisa

//        if(possivelMusica.isPresent()){
//            return ResponseEntity.status(200).body(possivelMusica.get());
//        }
//        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable Integer id, @RequestBody Musica musicaParaAlterar){
        if(repository.existsById(id)){
            musicaParaAlterar.setId(id);
            Musica musicaAlterada = repository.save(musicaParaAlterar);
            return ResponseEntity.status(200).body(musicaAlterada);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/titulo/{titulo}") //localhost:8080/musicas/titulo/titulo?valor
    public ResponseEntity<List<Musica>> acharPorTitulo(@RequestParam String titulo){
        List<Musica> possivelMusica = repository.findByTituloContainingIgnoreCase(titulo);
        if(possivelMusica.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(possivelMusica);
    }

    @GetMapping("/mais-recente")
    public ResponseEntity<Musica> buscarMaisRecente(){
        Optional<Musica> musicaRecente = repository.findFirstByOrderByDataLancamentoDesc();

        return ResponseEntity.of(musicaRecente);
    }

    //GET/musicas/antes?data=...

    @GetMapping("/{data}")
    public ResponseEntity<List<Musica>> buscarDataAntecedente(@RequestParam LocalDate data){
        List<Musica> musicasAntecedentes = repository.findByDataLancamentoDateBefore(data);
        if(musicasAntecedentes.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(musicasAntecedentes);
    }
}

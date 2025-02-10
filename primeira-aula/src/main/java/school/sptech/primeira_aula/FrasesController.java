package school.sptech.primeira_aula;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RestController = premissa é atender requisições e devolver respostas - devolver dados brutos
//Controller = serve para entender arquiteturas em formato mvc
@RestController //Anotação
public class FrasesController { //objeto gerenciado pelo framework (trabalha com padrões de projeto)

    @GetMapping("/frases/saudacao") //Endpoint != rota
    public String saudacao(){
        return "Olá mundo!";
    }

    // esse ("") do lado da anotação é o nome q vc ta dando pra ele não confundir
    @GetMapping("/frases/ola/{nome}") // => URI
    public String saudacao(@PathVariable String nome ){
        return "Ola %s".formatted(nome);
    }
}

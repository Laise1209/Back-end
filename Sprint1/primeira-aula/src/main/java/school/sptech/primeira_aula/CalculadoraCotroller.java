package school.sptech.primeira_aula;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class CalculadoraCotroller {
    private int contador;

    @GetMapping("/contar")
    private Integer contador(){
        return ++contador;
    };

    @GetMapping("/somar/{numero1}/{numero2}")
    public Integer somar(@PathVariable Integer numero1, @PathVariable Integer numero2){
        return numero1 + numero2;
    }

    @GetMapping("/subtrair")
    public Integer subtrair(){
        return 1;
    }
}

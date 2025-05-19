package school.sptech.testes.service;

public class CalculadoraService {
    public Double somar (Double a, Double b){
        if(a == null || b == null){
            throw new IllegalArgumentException("nao pode prç");
        }
        return a + b;
    }
}

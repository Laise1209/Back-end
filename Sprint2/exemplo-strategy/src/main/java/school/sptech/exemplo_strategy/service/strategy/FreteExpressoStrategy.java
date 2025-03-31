package school.sptech.exemplo_strategy.service.strategy;

public class FreteExpressoStrategy implements FreteStrategy{
    @Override
    public double calcular(double pesoEmKg) {
        return 30 + (pesoEmKg * 0.5);
    }
}

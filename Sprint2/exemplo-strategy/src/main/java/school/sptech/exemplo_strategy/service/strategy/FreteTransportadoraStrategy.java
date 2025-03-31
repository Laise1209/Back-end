package school.sptech.exemplo_strategy.service.strategy;

public class FreteTransportadoraStrategy implements FreteStrategy{
    @Override
    public double calcular(double pesoEmKg) {
        return 20.0 + (pesoEmKg * 0.2);
    }
}

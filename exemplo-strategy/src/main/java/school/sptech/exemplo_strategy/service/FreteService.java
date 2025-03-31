package school.sptech.exemplo_strategy.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;
import school.sptech.exemplo_strategy.exception.FreteInvalidoException;
import school.sptech.exemplo_strategy.repository.FreteRepository;
import school.sptech.exemplo_strategy.service.strategy.FreteExpressoStrategy;
import school.sptech.exemplo_strategy.service.strategy.FreteNormalStrategy;
import school.sptech.exemplo_strategy.service.strategy.FreteStrategy;
import school.sptech.exemplo_strategy.service.strategy.FreteTransportadoraStrategy;

import java.util.List;
import java.util.Map;

@Service
public class FreteService {

    private final FreteRepository freteRepository;
    private Map<TipoFreteEnum, FreteStrategy> estrategias;


    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
        this.estrategias = Map.of(
                TipoFreteEnum.NORMAL, new FreteNormalStrategy(),
                TipoFreteEnum.EXPRESSO, new FreteExpressoStrategy(),
                TipoFreteEnum.TRANSPORTADORA, new FreteTransportadoraStrategy()
        );
    }
    
    public Frete registrarCotacao(Frete frete) {
        FreteStrategy freteStrategy = estrategias.get(frete.getTipo());
        double valorFrete = freteStrategy.calcular(frete.getPesoEmKg());
        frete.setValorFrete(valorFrete);
        return freteRepository.save(frete);
    }

    public List<Frete> listarCotacoes() {
        return freteRepository.findAll();
    }
}

package school.sptech.exemplo_strategy.entity;

import school.sptech.exemplo_strategy.exception.FreteInvalidoException;

public enum TipoFreteEnum {
    NORMAL("Entrega em até 12 dias úteis"),
    EXPRESSO("Entrega em até 3 dias úteis"),
    TRANSPORTADORA("Entrega em até 6 dias úteis");

    private final String descricao;

    TipoFreteEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoFreteEnum fromString(String tipo) {
        for (TipoFreteEnum tipoFrete : TipoFreteEnum.values()) {
            if (tipoFrete.name().equalsIgnoreCase(tipo)) {
                return tipoFrete;
            }
        }
        throw new FreteInvalidoException("Tipo de frete inválido: " + tipo);
    }
}

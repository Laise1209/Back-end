package school.sptech.exemplo_strategy.controller.dto;

import school.sptech.exemplo_strategy.entity.Frete;

public class FreteResumidoDto {

    private Integer id;
    private String tipo;
    private Double valor;

    public static FreteResumidoDto toFreteResumidoDto(Frete entity) {
        FreteResumidoDto dto = new FreteResumidoDto();
        dto.setValor(entity.getValorFrete());
        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo().name());
        return dto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

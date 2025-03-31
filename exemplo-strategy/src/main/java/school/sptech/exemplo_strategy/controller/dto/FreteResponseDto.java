package school.sptech.exemplo_strategy.controller.dto;

import school.sptech.exemplo_strategy.entity.Frete;

public class FreteResponseDto {
    private Integer id;
    private String tipo;
    private String descricao;
    private Double valorFrete;

    public static FreteResponseDto toResponseDto(Frete frete) {
        FreteResponseDto responseDto = new FreteResponseDto();
        responseDto.setId(frete.getId());
        responseDto.setTipo(frete.getTipo().name());
        responseDto.setDescricao(frete.getTipo().getDescricao());
        responseDto.setValorFrete(frete.getValorFrete());
        return responseDto;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }
}

package school.sptech.exemplo_strategy.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;

public class FreteRequestDto {

    @NotNull
    @Positive
    @DecimalMin(value = "1.0")
    @Schema(description="Peso do produto em KG", example="10.0")
    private Double pesoEmKg;

    @NotNull
    @NotBlank
    @Schema(description="Tipo do frete", allowavleValues={
            "NORMAL",
            "EXPRESSO",
            "TRANSPORTADORA"
    })
    private String tipo;

    @NotNull
    @Positive
    @DecimalMin(value = "10.0")
    private Double valorEncomenda;
     //mapper - transforma o request em frete
    public static Frete toEntity(FreteRequestDto dto) {
        Frete frete = new Frete();
        frete.setPesoEmKg(dto.getPesoEmKg());
        frete.setTipo(TipoFreteEnum.fromString(dto.getTipo()));
        frete.setValorEncomenda(dto.getValorEncomenda());
        return frete;
    }

    public Double getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(Double pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorEncomenda() {
        return valorEncomenda;
    }

    public void setValorEncomenda(Double valorEncomenda) {
        this.valorEncomenda = valorEncomenda;
    }
}

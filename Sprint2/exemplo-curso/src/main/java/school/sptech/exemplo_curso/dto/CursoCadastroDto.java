package school.sptech.exemplo_curso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoCadastroDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    @Positive
    private Double preco;
    @NotBlank
    private String categoria;
}

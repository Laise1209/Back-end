package school.sptech.exemplo_curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoListagemDto {
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
}

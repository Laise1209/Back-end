package school.sptech.exemplo_curso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ra;
    private String nome;
    @ManyToOne
    private Curso curso; //fk da entidade forte
}

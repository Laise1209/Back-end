package school.sptech.exemplo_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_service.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByCodigoIgnoreCase(String codigo);
}

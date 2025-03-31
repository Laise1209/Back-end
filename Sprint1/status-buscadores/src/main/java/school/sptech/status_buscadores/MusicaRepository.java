package school.sptech.status_buscadores;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    List<Musica> findByTituloContainingIgnoreCase(String titulo);


    Optional<Musica> findFirstByOrderByDataLancamentoDesc();


    List<Musica> findByDataLancamentoDateBefore(LocalDate data);
}

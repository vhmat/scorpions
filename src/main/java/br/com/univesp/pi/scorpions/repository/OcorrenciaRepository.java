package br.com.univesp.pi.scorpions.repository;

import br.com.univesp.pi.scorpions.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}

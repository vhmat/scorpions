package br.com.univesp.pi.scorpions.service;

import br.com.univesp.pi.scorpions.model.Ocorrencia;
import br.com.univesp.pi.scorpions.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;

    public OcorrenciaService(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    public List<Ocorrencia> listarTodas() {
        return repository.findAll();
    }

    public Optional<Ocorrencia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        return repository.save(ocorrencia);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Ocorrencia> filtrar(String bairro, Integer ano) {
        return listarTodas().stream()
                .filter(o -> (bairro == null || bairro.isBlank() || o.getBairro().equalsIgnoreCase(bairro)))
                .filter(o -> {
                    if (ano == null) return true;
                    return o.getDataOcorrencia() != null && o.getDataOcorrencia().getYear() == ano;
                })
                .toList();
    }
}


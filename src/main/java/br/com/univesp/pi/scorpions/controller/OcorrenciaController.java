package br.com.univesp.pi.scorpions.controller;

import br.com.univesp.pi.scorpions.model.Ocorrencia;
import br.com.univesp.pi.scorpions.service.OcorrenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ocorrencia> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filtrar")
    public List<Ocorrencia> filtrar(
            @RequestParam(required = false) String bairro,
            @RequestParam(required = false) Integer ano) {
        return service.filtrar(bairro, ano);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Ocorrencia ocorrencia) {
        try {
            Ocorrencia salvo = service.salvar(ocorrencia);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            e.printStackTrace(); // Isso vai imprimir o erro no console
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar: " + e.getMessage());
        }
    }

/*    @PostMapping
    public Ocorrencia criar(@RequestBody Ocorrencia ocorrencia) {

        return service.salvar(ocorrencia);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(@PathVariable Long id, @RequestBody Ocorrencia novaOcorrencia) {
        return service.buscarPorId(id).map(ocorrencia -> {
            ocorrencia.setBairro(novaOcorrencia.getBairro());
            ocorrencia.setCidade(novaOcorrencia.getCidade());
            ocorrencia.setLatitude(novaOcorrencia.getLatitude());
            ocorrencia.setLongitude(novaOcorrencia.getLongitude());
            ocorrencia.setDataOcorrencia(novaOcorrencia.getDataOcorrencia());
            return ResponseEntity.ok(service.salvar(ocorrencia));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

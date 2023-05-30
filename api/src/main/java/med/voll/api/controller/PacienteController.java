package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.DadosPacienteListagem;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping()
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(pacienteDTO);
        repository.save(paciente);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosPacienteListagem>> listar(@PageableDefault(size = 10, sort = {"nome", "cpf"}) Pageable page){
        var results = repository.findAllByAtivoTrue(page).map(DadosPacienteListagem::new);
        return ResponseEntity.ok(results);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosPacienteUpdate dadosAtualiza){
        var paciente = repository.getReferenceById(dadosAtualiza.id());
        paciente.atualizar(dadosAtualiza);
        return ResponseEntity.ok(new DetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativa();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPaciente(@PathVariable Long id){
        var paciente  = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoPaciente(paciente));
    }
}

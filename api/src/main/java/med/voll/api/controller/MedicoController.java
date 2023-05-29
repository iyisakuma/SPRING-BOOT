package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uriBuilder ) {
        var medico = new Medico(medicoDTO);
        repository.save(medico);
        var dto = new DetalhamentoMedico(medico);
        var uri = uriBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }


    @GetMapping
    public ResponseEntity<Page<DadosMedicoListagem>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        var pageResult =  repository.findAllByAtivoTrue(page).map(DadosMedicoListagem::new);
        return ResponseEntity.ok(pageResult);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosMedicoAtualizacao dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
        return ResponseEntity.ok(new DetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.exclui();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalha(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoMedico(medico));
    }
}

package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDTO dto) {
        repository.save(new Medico(dto));
    }


    @GetMapping
    public Page<DadosMedicoListagem> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        return repository.findAllByAtivoTrue(page).map(DadosMedicoListagem::new);

    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosMedicoAtualizacao dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.exclui();
    }
}

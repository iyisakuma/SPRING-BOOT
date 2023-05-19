package med.voll.api.controller;

import jakarta.persistence.Table;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteDTO;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping()
    @Transactional
    public void cadastrar(@RequestBody PacienteDTO pacienteDTO){
        repository.save(new Paciente(pacienteDTO));
    }

    @GetMapping
    public Page<DadosPacienteListagem> listar(@PageableDefault(size = 10, sort = {"nome", "cpf"}) Pageable page){
        return repository.findAll(page).map(DadosPacienteListagem::new);
    }
}

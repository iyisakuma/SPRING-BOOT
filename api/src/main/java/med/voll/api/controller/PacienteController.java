package med.voll.api.controller;

import med.voll.api.paciente.PacienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @PostMapping()
    public void cadastrar(@RequestBody PacienteDTO pacienteDTO){
        System.out.println(pacienteDTO);
    }
}

package med.voll.api.controller;

import med.voll.api.medico.Especialidade;
import med.voll.api.medico.Medico;

public record DadosMedicoListagem(String nome, String email, String crm, Especialidade especialidade) {
    public DadosMedicoListagem(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

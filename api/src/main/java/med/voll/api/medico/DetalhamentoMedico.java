package med.voll.api.medico;

import med.voll.api.endereco.Endereco;

public record DetalhamentoMedico(Long id, String nome, String crm, String email, String telefone, Especialidade especialidade, Endereco endereco) {
    public DetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}


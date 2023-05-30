package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DetalhamentoPaciente(Long id, String telefone, String nome, String cpf, String email, Endereco endereco) {
    public DetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getTelefone(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getEndereco());
    }
}

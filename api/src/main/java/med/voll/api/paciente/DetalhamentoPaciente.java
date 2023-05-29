package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DetalhamentoPaciente(Long id, String telefone, String nome, String cpf, String email, Endereco endereco) {
    public DetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getTelefone(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getEndereco());
    }
}

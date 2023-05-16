package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

public record PacienteDTO(String nome, String email, String cpf, DadosEndereco endereco) {
}

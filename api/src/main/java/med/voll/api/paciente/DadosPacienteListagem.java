package med.voll.api.paciente;

import med.voll.api.paciente.Paciente;

public record DadosPacienteListagem(Long id, String nome, String email, String cpf) {
    public DadosPacienteListagem(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}

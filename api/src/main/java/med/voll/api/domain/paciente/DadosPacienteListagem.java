package med.voll.api.domain.paciente;

public record DadosPacienteListagem(Long id, String nome, String email, String cpf) {
    public DadosPacienteListagem(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}

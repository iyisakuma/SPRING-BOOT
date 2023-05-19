package med.voll.api.controller;

import med.voll.api.paciente.Paciente;

public record DadosPacienteListagem(String nome, String email, String cpf) {
    public DadosPacienteListagem(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}

package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record PacienteDTO(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank( message = "{telefone.obrigatorio}")
        String telefone,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{cpf.obrigatorio}")
        String cpf,
        @Valid
        @NotNull(message = "{endereco.obrigatorio}")
        DadosEndereco endereco) {
}

package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record MedicoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{2,6}")
        String crm,
        @NotBlank
        String telefone,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}

package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record MedicoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato inválido")
        String email,
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{2,6}", message = "CRM inválido")
        String crm,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotNull(message = "Especidalidade é obrigatório")
        Especialidade especialidade,
        @NotNull(message = "Endereço é obrigatório")
        @Valid()
        DadosEndereco endereco) {
}

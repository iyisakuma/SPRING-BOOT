package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

import java.io.Serializable;

@Table(name = "paciente")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private String nome;
    private String cpf;
    private String email;
    private boolean ativo = true;
    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDTO dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.endereco());
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
    }

    public void atualizar(DadosPacienteUpdate novosDados) {
        if(novosDados.nome() != null){
            this.nome = novosDados.nome();
        }
        if(novosDados.telefone() != null){
            this.telefone = novosDados.telefone();
        }
        if(novosDados.endereco() != null){
            this.endereco.atualizaDado(novosDados.endereco());
        }
    }

    public void inativa() {
        this.ativo = false;
    }
}

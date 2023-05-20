package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizaDado(Endereco novoEndereco) {
        if (novoEndereco.getLogradouro().trim() != null) {
            this.logradouro = novoEndereco.logradouro;
        }
        if (novoEndereco.getBairro().trim() != null) {
            this.bairro = novoEndereco.bairro;
        }
        if (novoEndereco.getCep().trim() != null) {
            this.cep = novoEndereco.cep;
        }
        if (novoEndereco.getNumero().trim() != null) {
            this.numero = novoEndereco.numero;
        }
        if (novoEndereco.getComplemento().trim() != null) {
            this.complemento = novoEndereco.complemento;
        }
        if (novoEndereco.getCidade().trim() != null) {
            this.cidade = novoEndereco.cidade;
        }
        if (novoEndereco.getUf().trim() != null) {
            this.uf = novoEndereco.uf;
        }
    }
}

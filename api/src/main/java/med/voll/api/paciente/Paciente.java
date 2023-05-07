package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Entity(name = "Paciente")
@Table(name="pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private boolean ativo;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
    
        if (dados.telefone() != null)
            this.telefone = dados.telefone();
    
        if (dados.endereco() != null)
            endereco.atualizarInformacoes(dados.endereco());
    }
    
    public void inativar() {
        this.ativo = false;
    }
        
}

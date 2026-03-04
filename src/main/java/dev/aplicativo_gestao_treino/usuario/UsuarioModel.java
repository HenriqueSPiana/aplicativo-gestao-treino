package dev.aplicativo_gestao_treino.usuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="nome")
    private String nome;

    @Column(name ="email")
    private String email;

    @Column(name ="senha")
    private String senha;

    @Column(name ="endereco")
    private String endereco;

    @Column(name = "treino")
    private Long idTreino; //mudar para classe TREINO quando criar

}

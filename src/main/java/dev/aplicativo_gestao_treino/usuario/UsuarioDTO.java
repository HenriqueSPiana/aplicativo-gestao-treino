package dev.aplicativo_gestao_treino.usuario;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {


    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;

    private Long idTreino; //mudar para classe TREINO quando criar

}

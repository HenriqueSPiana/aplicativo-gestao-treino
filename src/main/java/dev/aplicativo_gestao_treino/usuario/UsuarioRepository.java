package dev.aplicativo_gestao_treino.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {


    @Query("SELECT n FROM UsuarioModel n where" +
            "(:nome IS NULL OR n.nome LIKE %:nome%) AND " +
            "(:email IS NULL OR n.email LIKE %:email%)")
    Page<UsuarioModel> findUsuarioComFiltro(@Param("nome") String nome,
                                            @Param("nome") String email,
                                            Pageable pageable
    );
}

package dev.aplicativo_gestao_treino.usuario;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T23:50:42-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDTO(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        return usuarioDTO;
    }

    @Override
    public UsuarioModel toModel(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        return usuarioModel;
    }
}

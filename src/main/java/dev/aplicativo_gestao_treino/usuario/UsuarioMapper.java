package dev.aplicativo_gestao_treino.usuario;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO map(UsuarioDTO usuarioDTO);

    UsuarioModel map(UsuarioModel usuarioModel);
}

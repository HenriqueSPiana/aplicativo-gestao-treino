package dev.aplicativo_gestao_treino.usuario;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(UsuarioModel usuarioModel);

    UsuarioModel toModel(UsuarioDTO usuarioDTO);
}

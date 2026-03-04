package dev.aplicativo_gestao_treino.usuario;


import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }


    //listar


    //buscar por id


    //criar


    //deletar




}

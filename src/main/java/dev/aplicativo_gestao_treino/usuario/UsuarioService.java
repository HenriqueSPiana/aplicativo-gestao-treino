package dev.aplicativo_gestao_treino.usuario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }


    //buscar
    public Page<UsuarioDTO> buscarUsuario(String nome, String email, Pageable pageable)
    {
        Page<UsuarioModel> usuario = usuarioRepository.findUsuarioComFiltro(nome, email, pageable);
        return usuario.map(usuarioMapper::toDTO);
    }


    //buscar por id
    public UsuarioDTO buscarUsuarioPorid(Long id){

        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.map(usuarioMapper::toDTO).orElse(null);

    }


    //criar
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMapper.toModel(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    //alterar
    public UsuarioDTO alterarUsuario(Long id, UsuarioDTO usuarioDTO){

        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            UsuarioModel usuarioAtualizado = usuarioMapper.toModel(usuarioDTO);
            usuarioAtualizado.setId(id);
            return usuarioMapper.toDTO(usuarioRepository.save(usuarioAtualizado));
        }
        return null;
    }

    //deletar

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }



}

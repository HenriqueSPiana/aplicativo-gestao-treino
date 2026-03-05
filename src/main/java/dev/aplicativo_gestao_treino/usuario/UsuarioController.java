package dev.aplicativo_gestao_treino.usuario;


import dev.aplicativo_gestao_treino.core.dto.PageResponseDTO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/criar")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @PostMapping("/alterar/{id}")
    public ResponseEntity<?>  alterarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuario){
        return  ResponseEntity.ok(usuarioService.alterarUsuario(id,usuario));
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        if(usuarioService.buscarUsuarioPorid(id) != null ){
            usuarioService.deletarUsuario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario deletado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario não existe");
    }


    @GetMapping("/buscar/{id}")
    public UsuarioDTO buscarUsuarioPorid(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorid(id);
    }


    @GetMapping("/buscar")
    public PageResponseDTO<UsuarioDTO> buscarUsuario(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @ParameterObject
            @PageableDefault(page = 0, size = 10, sort = "nome") Pageable pageable
    ){
        Page<UsuarioDTO> paginaDeUsuario  = usuarioService.buscarUsuario(nome,email,pageable);
        return new PageResponseDTO<>(paginaDeUsuario);

    }

}



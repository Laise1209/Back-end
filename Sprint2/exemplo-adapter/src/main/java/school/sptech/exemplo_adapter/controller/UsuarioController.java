package school.sptech.exemplo_adapter.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_adapter.entity.Usuario;
import school.sptech.exemplo_adapter.response.LoginRequestDTO;
import school.sptech.exemplo_adapter.response.UsuarioRequestDTO;
import school.sptech.exemplo_adapter.response.UsuarioResponseDTO;
import school.sptech.exemplo_adapter.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private final UsuarioService service;

    public UsuarioController(UsuarioService service, List<Usuario> usuarios) {
        this.service = service;
        this.usuarios = usuarios;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(@Valid @RequestBody Usuario usuario) {
        List<Usuario> todos = service.listar(usuarios);
        if(todos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        List<UsuarioResponseDTO> usuarioResponse = new ArrayList<>();
        for (Usuario user: usuarios){
            usuarioResponse.add(UsuarioResponseDTO.toResponse(usuario));
        }
        return ResponseEntity.status(200).body(todos);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(List<Usuario> usuarios, @RequestBody UsuarioRequestDTO usuarioRequest) {
        Usuario novoUsuario = service.cadastrar(UsuarioRequestDTO.toEntity(usuarioRequest));
        return ResponseEntity.created(null).body(UsuarioResponseDTO.toResponse(novoUsuario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> autenticarUsuario(@Valid @RequestBody LoginRequestDTO dto) {
        boolean isValido = service.validarUsuario(dto.getUsuario(), dto.getSenha());
        if(isValido){
            return ResponseEntity.ok("Usuario autenticado");
        }
        return ResponseEntity.ok("Usuario NAO autenticado");

    }
}

package school.sptech.exemplo_adapter.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_adapter.entity.Usuario;
import school.sptech.exemplo_adapter.exception.UsuarioExistenteException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listar(List<Usuario> usuarios){
        return this.usuarios;
    }

    public Usuario cadastrar( Usuario usuario){
        try{
            usuario.setId(UUID.randomUUID());
            usuarios.add(usuario);
            return usuario;
        } catch (UsuarioExistenteException e){
            throw new UsuarioExistenteException("Tentativa de cadastro de usuário já existente");
        }
    }

    public boolean validarUsuario(String usuario, String senha) {
        for (Usuario usuarioDaVez : usuarios) {
            if(usuario.equals(usuarioDaVez.getEmail()) && senha.equals(usuarioDaVez.getSenha())){
                usuarioDaVez.setAutenticado(true);
                return true;
            }
        }
        return false;
    }
}

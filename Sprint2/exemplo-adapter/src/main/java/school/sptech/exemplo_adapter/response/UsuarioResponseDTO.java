package school.sptech.exemplo_adapter.response;

import school.sptech.exemplo_adapter.entity.Usuario;

import java.util.UUID;

public class UsuarioResponseDTO {
    private UUID id;
    private String nome;
    private String email;
    private boolean autenticado;

    public UsuarioResponseDTO(UUID id, String nome, String email, boolean autenticado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.autenticado = autenticado;
    }

    public UsuarioResponseDTO() {

    }

    public static UsuarioResponseDTO toResponse(Usuario usuario){
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setEmail(usuario.getEmail());
        dto.setNome(usuario.getNome());
        dto.setAutenticado(usuario.isAutenticado());
        return dto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}

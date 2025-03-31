package school.sptech.exemplo_adapter.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {
    @Email
    @NotBlank
    private String usuario;
    @NotBlank
    private String senha;

    public LoginRequestDTO(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public LoginRequestDTO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

package dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AutenticacaoUsuarioDTO {

    @NotBlank (message = "Campo Login é obrigatório")
    public String login;
    
    @NotBlank (message = "Campo Senha é obrigatório")
    public String senha;
    
}

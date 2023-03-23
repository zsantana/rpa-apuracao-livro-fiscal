package entities;

import java.util.UUID;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name = "USUARIO_PAINEL")
@Data
public class UsuarioEntity {

    @Id
    @Column(name = "id")
    public UUID id;

    @Column(name = "login")
    public String login;

    @Column(name = "senha")
    public String senha;

    @Column(name = "token")
    public String token;

    @Column(name = "role")
    public String role;

}
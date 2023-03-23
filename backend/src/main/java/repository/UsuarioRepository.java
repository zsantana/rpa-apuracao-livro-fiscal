package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import dto.AutenticacaoUsuarioDTO;
import entities.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepositoryBase<UsuarioEntity, UUID> {

    public Optional<UsuarioEntity> obterCredencial(AutenticacaoUsuarioDTO autenticacaoUsuario) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("login", autenticacaoUsuario.login);
        params.put("senha", autenticacaoUsuario.senha);
        
        return find("login = :login and senha = :senha ", params).firstResultOptional();
    }


}
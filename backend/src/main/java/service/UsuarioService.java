package service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.AutenticacaoUsuarioDTO;
import entities.UsuarioEntity;
import repository.UsuarioRepository;



@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository repo;

    
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    //@Transactional
    public boolean validaCredencial(AutenticacaoUsuarioDTO autenticacaoUsuario){
        
        logger.info("Buscando usuário: " + autenticacaoUsuario.login);
        Optional<UsuarioEntity> user = repo.obterCredencial(autenticacaoUsuario);
        
        return user.isPresent();
    }

}
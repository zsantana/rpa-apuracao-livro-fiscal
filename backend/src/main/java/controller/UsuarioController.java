package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.AutenticacaoUsuarioDTO;
import dto.ResponseTokenDTO;
import io.smallrye.jwt.build.Jwt;
import service.UsuarioService;

import java.time.Duration;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/autenticacao/usuario")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    
    @Inject
    UsuarioService usuarioService;

    
    @GET
    @Path("/token")
    @Produces(MediaType.TEXT_PLAIN)
    public String getToken(){

        logger.info("Gerando token ...");

        String token = Jwt.upn("techjs@gmail.com")
                        .issuer("https://dev.fiscal/api/v1/autenticacao/usuarios")
                        .groups("Admin")
                        .expiresIn(Duration.ofMinutes(480)) // Sessão de 5 minutos
                        .sign();

        logger.info("Token: " + token);

        return token;

    }



    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validaToken(@Valid AutenticacaoUsuarioDTO autenticacaoUsuario ) {

        logger.info("Tentativa de autenticação do usuário: " + autenticacaoUsuario.login);
        
        if (usuarioService.validaCredencial(autenticacaoUsuario)){
            
            String token = getToken();
            logger.info("Respondendo o TOKEN: " + token);

            ResponseTokenDTO responseTokenDTO = new ResponseTokenDTO();
            responseTokenDTO.token = token;

            return Response.ok(responseTokenDTO).build();

        }else{

            return Response.status(422).entity("Falha na autenticação").build();

        }
        
        

    }


}
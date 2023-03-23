package controller;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.PainelFiscalEntity;
import service.PainelFiscalService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/painel")
public class PainelFiscalController {

    private static final Logger logger = LoggerFactory.getLogger(PainelFiscalController.class);
    
    @Inject
    PainelFiscalService servico;

   
    @GET
    @Path("/apuracao/{mesano}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(
            responseCode = "200",
            description = "Listagem da apuração fiscal",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = PainelFiscalEntity.class)
            )
    )
    public Response obterApuracaoMesAno(@PathParam("mesano") String mesano) {
        logger.info("Buscando apuração para mês/ano: " + mesano);
        return Response.ok(servico.obterApuracao(mesano)).build();
    }


    @GET
    @Path("/apuracao/mesano/{mesano}/filial/{filial}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(
            responseCode = "200",
            description = "Listagem da apuração fiscal Brinks",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = PainelFiscalEntity.class)
            )
    )
    public Response obterApuracaoMesAnoFilial(@PathParam("mesano") String mesano, @PathParam("filial") String filial) {
        logger.info("Buscando apuração mês/ano " + mesano + " por filial: " + filial);
        return Response.ok(servico.obterApuracaoMesAnoFilial(mesano, filial)).build();
    }


}
package controller;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s3.CommonResource;
import service.BucketService;


@Path("/api/v1/bucket")
public class DownloadBucketController extends CommonResource {
    
    private static final Logger logger = LoggerFactory.getLogger(DownloadBucketController.class);

    @Inject
    BucketService bucketService;


    @GET
    @Path("/download/livrofiscal/{chavebucket}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @APIResponse(
            responseCode = "200",
            description = "Download do livro fiscal PDF"
    )
    public Response obterLivroFiscalPDF(@PathParam("chavebucket") String chavebucket) {
        logger.info("Chamando serviço de Download do Livro Fiscal: " + chavebucket);
        return bucketService.obterLivroFiscalPDF(chavebucket).build();
    }

    
    @GET
    @Path("/download/emissaoguia/{chavebucket}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @APIResponse(
            responseCode = "200",
            description = "Download do Emissão Guia PDF"
    )
    public Response obterEmissaoGuiaPDF(@PathParam("chavebucket") String chavebucket) {
        logger.info("Chamando serviço de Download do Emissão Guia : " + chavebucket);
        return bucketService.obterEmissaoGuiaPDF(chavebucket).build();
    }


    @GET
    @Path("/download/synchro/{chavebucket}")
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @APIResponse(
            responseCode = "200",
            description = "Download do Synchro PDF"
    )
    public Response obterSynchroPDF(@PathParam("chavebucket") String chavebucket) {
        logger.info("Chamando serviço de Download do Synchro: " + chavebucket);
        return bucketService.obterSynchroPDF(chavebucket).build();
    }

}
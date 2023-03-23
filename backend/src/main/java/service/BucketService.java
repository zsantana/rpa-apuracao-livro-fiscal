package service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.ControleApuracaoFilialEntity;
import repository.ControleApuracaoFiscalRepository;
import s3.CommonResource;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;



@ApplicationScoped
public class BucketService extends CommonResource {

    private static final Logger logger = LoggerFactory.getLogger(BucketService.class);
    private String msgErro = "Bucket não cadastrado.";

    @Inject
    S3Client s3;

    @Inject
    ControleApuracaoFiscalRepository repo;


    public ResponseBuilder obterLivroFiscalPDF(String chavebucket) {
        
        logger.info("Efetuando download do livro fiscal PDF: " + chavebucket);
        ControleApuracaoFilialEntity dao = repo.obterChaveBucket(chavebucket);

        if (dao.getNomeBucketLivroFiscal().isEmpty()){
            throw new WebApplicationException(Response.status(422).entity(msgErro).build());
        }else{
            
            return efetuarDownload(dao.getNomeBucketLivroFiscal());

        }
        
    }


    public ResponseBuilder obterEmissaoGuiaPDF(String chavebucket) {
        
        logger.info("Efetuando download do livro fiscal PDF: " + chavebucket);
        ControleApuracaoFilialEntity dao = obterDao(chavebucket);

        if (dao.getNomeBucketEmissaoGuia().isEmpty()){
            throw new WebApplicationException(Response.status(422).entity(msgErro).build());
        }else{
            
            return efetuarDownload(dao.getNomeBucketEmissaoGuia());

        }
        
    }


    public ResponseBuilder obterSynchroPDF(String chavebucket) {
        
        logger.info("Efetuando download do livro fiscal PDF: " + chavebucket);
        ControleApuracaoFilialEntity dao = obterDao(chavebucket);

        if (dao.getNomeBucketSynchro().isEmpty()){
            throw new WebApplicationException(Response.status(422).entity(msgErro).build());
        }else{
            
            return efetuarDownload(dao.getNomeBucketSynchro());

        }
        
    }


    private ResponseBuilder efetuarDownload(String bucketName) {
        ResponseBytes<GetObjectResponse> objectBytes = s3.getObjectAsBytes(buildGetRequest(bucketName));
        ResponseBuilder response = Response.ok(objectBytes.asByteArray());
        response.header("Content-Disposition", "attachment;filename=" + bucketName);
        response.header("Content-Type", objectBytes.response().contentType());
        return response;
    }


    private ControleApuracaoFilialEntity obterDao(String chavebucket){
        return repo.obterChaveBucket(chavebucket);
    }



}
package s3;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import software.amazon.awssdk.services.s3.model.GetObjectRequest;

abstract public class CommonResource {

    private static final Logger logger = LoggerFactory.getLogger(CommonResource.class);

    String msgErro = "Erro ao efetuar download no Bucket";
    
    @ConfigProperty(name = "bucket.bucketName")
    String bucketName;


    protected GetObjectRequest buildGetRequest(String objectKey) {
        logger.info("Acessando o bucket para download: " + bucketName);
        
        try {
        
            return GetObjectRequest.builder().bucket(bucketName).key(objectKey).build();
        
        } catch (Exception ase) {
        
            logger.error("### Erro ao conectar ao bucket:" + bucketName);
			logger.error("### Error Message: " + ase.getMessage());
            throw new WebApplicationException(Response.status(422).entity(msgErro).build());
			
        } 
        
    }

}

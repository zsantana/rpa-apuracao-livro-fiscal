package service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.PainelFiscalEntity;
import repository.PainelFiscalRepository;



@ApplicationScoped
public class PainelFiscalService {

    String msgErro = "Parâmetro Mês/Ano incorreto";

    @Inject 
    EntityManager em;

    @Inject
    PainelFiscalRepository repo;

    
    private static final Logger logger = LoggerFactory.getLogger(PainelFiscalService.class);

    //@Transactional
    public List<PainelFiscalEntity> obterApuracao(String mesAnoCompetencia){
        var mesano = formatarMesAno(mesAnoCompetencia);
        logger.info("mesAnoCompetencia: " + mesano);

        TypedQuery<PainelFiscalEntity> query =  em.unwrap(Session.class)
        .createNativeQuery(
            "SELECT * FROM V_APURACAO_FISCAL WHERE mes_ano_competencia = :mesAnoCompetencia order by nom_filial", 
            PainelFiscalEntity.class);

            query.setParameter("mesAnoCompetencia", mesano)                 ;
            return query.getResultList();
    }


    public List<PainelFiscalEntity> obterApuracaoMesAnoFilial(String mesAnoCompetencia, String nomeFilial){
        var mesano = formatarMesAno(mesAnoCompetencia);
        logger.info("mesAnoCompetencia: " + mesano);

        TypedQuery<PainelFiscalEntity> query =  em.unwrap(Session.class)
        .createNativeQuery(
                       " SELECT * FROM V_APURACAO_FISCAL " + 
                       "  WHERE mes_ano_competencia = :mesAnoCompetencia " +
                       "    AND nom_filial = :nomeFilial "+
                       "  ORDER BY nom_filial", 
            PainelFiscalEntity.class);

            query.setParameter("mesAnoCompetencia", mesano);
            query.setParameter("nomeFilial", nomeFilial);
            return query.getResultList();
    }

    
    private String formatarMesAno(String mesAnoCompetencia) {
        if (mesAnoCompetencia.length() < 6)
           throw new WebApplicationException(Response.status(422).entity(msgErro).build());
        return mesAnoCompetencia.subSequence(0, 2) + "/" + mesAnoCompetencia.subSequence(2, 6);
    }

}
package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import entities.PainelFiscalEntity;

@ApplicationScoped
public class PainelFiscalRepository implements PanacheRepositoryBase<PainelFiscalEntity, UUID> {

    public List<PainelFiscalEntity> obterApuracao(String mesAno) {
        Map<String, Object> params = new HashMap<>();
        params.put("mesAnoCompetencia", mesAno);
        
        return find("mesAnoCompetencia = :mesAnoCompetencia ", params).list();
    }


}
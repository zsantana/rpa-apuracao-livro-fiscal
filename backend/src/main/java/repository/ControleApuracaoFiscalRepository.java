package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import entities.ControleApuracaoFilialEntity;

@ApplicationScoped
public class ControleApuracaoFiscalRepository implements PanacheRepositoryBase<ControleApuracaoFilialEntity, UUID> {

    public ControleApuracaoFilialEntity obterChaveBucket(String uuid) {
        return findById( UUID.fromString(uuid));
    }


}
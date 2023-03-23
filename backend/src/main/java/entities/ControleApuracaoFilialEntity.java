package entities;

import java.util.UUID;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name = "CONTROLE_APURACAO_FILIAL")
@Data
public class ControleApuracaoFilialEntity {

    @Id
    @Column(name = "uuid")
    public UUID id;

    @Column(name = "nom_bucket_livro_fiscal_pdf")
    public String nomeBucketLivroFiscal;

    @Column(name = "nom_bucket_emissao_guia_pdf")
    public String nomeBucketEmissaoGuia;

    @Column(name = "nom_bucket_synchro_pdf")
    public String nomeBucketSynchro;
}
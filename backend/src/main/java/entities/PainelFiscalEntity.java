package entities;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Immutable
//@Subselect("select * from V_APURACAO_FISCAL ")
@Table(name = "V_APURACAO_FISCAL", schema = "public")
@Data
public class PainelFiscalEntity {

    @Id
    @Column(name = "id")
    public UUID id;

    @JsonProperty("nomeFilial")
    @Column(name = "nom_filial")
    public String nomeFilial;

    @JsonProperty("mesAnoCompetencia")
    @Column(name = "mes_ano_competencia")
    public String mesAnoCompetencia;

    @JsonProperty("valorTotalFaturaPref")
    @Column(name = "val_total_fatura_pref")
    public BigDecimal valorTotalFaturaPref;

    @JsonProperty("valorBaseCalculoPref")
    @Column(name = "val_base_calculo_pref")
    public BigDecimal valorBaseCalculoPref;

    @JsonProperty("valorTotalImpostoPref")
    @Column(name = "val_total_imposto_pref")
    public BigDecimal valorTotalImpostoPref;

    @JsonProperty("valorTotalFaturaFatwin")
    @Column(name = "val_total_fatura_fatwin")
    public BigDecimal valorTotalFaturaFatwin;

    @JsonProperty("valorBaseCalculoFatwin")
    @Column(name = "val_base_calculo_fatwin")
    public BigDecimal valorBaseCalculoFatwin;

    @JsonProperty("valorTotalImpostoFatwin")
    @Column(name = "val_total_imposto_fatwin")
    public BigDecimal valorTotalImpostoFatwin;

    @JsonProperty("valorTotalFaturaSynchro")
    @Column(name = "val_total_fatura_synchro")
    public BigDecimal valorTotalFaturaSynchro;

    @JsonProperty("valorBaseCalculoSynchro")
    @Column(name = "val_base_calculo_synchro")
    public BigDecimal valorBaseCalculoSynchro;

    @JsonProperty("valorTotalImpostoSynchro")
    @Column(name = "val_total_imposto_synchro")
    public BigDecimal valorTotalImpostoSynchro;
    
    @JsonProperty("totalNotasFatwin")
    @Column(name = "tot_notas_fatwin")
    public BigDecimal totalNotasFatwin;

    @JsonProperty("totalNotasLivro")
    @Column(name = "tot_notas_livro")
    public BigDecimal totalNotasLivro;

    @JsonProperty("statusProcessamento")
    @Column(name = "status_processamento")
    public String statusProcessamento;

    @JsonProperty("CodCnpj")
    @Column(name = "cod_cnpj")
    public String CodCnpj;
}
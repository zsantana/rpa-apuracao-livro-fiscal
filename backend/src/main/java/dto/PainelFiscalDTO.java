package dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class PainelFiscalDTO {
    
    public UUID id;    
    
    @NotBlank(message = "Campo mesAnoCompetencia é obrigatório")
    public String mesAnoCompetencia;
    
    @NotBlank(message = "Campo nomeFilial é obrigatório")
    public String nomeFilial;

    public String dataEmissao;

    @NotNull (message = "Campo valorTotalFatura é obrigatório")
    public BigDecimal valorTotalFatura;

    @NotNull(message = "Campo valorBaseCalculo é obrigatório")
    public BigDecimal valorBaseCalculo;

    @NotNull(message = "Campo valorTotalImposto é obrigatório")
    public BigDecimal valorTotalImposto;

}
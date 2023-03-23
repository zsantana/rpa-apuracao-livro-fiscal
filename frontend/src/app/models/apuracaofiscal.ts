export interface ApuracaoFiscal {
  id: string;
  dataEmissao: string;
  mesAnoCompetencia: string;
  nomeFilial: string;
  valorTotalFaturaPref: number;
  valorBaseCalculoPref: number;
  valorTotalImpostoPref: number;
  valorTotalFaturaFatwin: number;
  valorBaseCalculoFatwin: number;
  valorTotalImpostoFatwin: number;
  valorTotalFaturaSynchro: number;
  valorBaseCalculoSynchro: number;
  valorTotalImpostoSynchro: number;
  totalNotasFatwin: number;
  totalNotasLivro: number;
  statusProcessamento: string;
  CodCnpj: string;
}

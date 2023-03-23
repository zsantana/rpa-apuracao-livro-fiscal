import { BlockScrollStrategy } from '@angular/cdk/overlay';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { Router } from '@angular/router';
import { interval, Subscription } from 'rxjs';
import { ApuracaoFiscal } from 'src/app/models/apuracaofiscal';
import { ApuracaoFiscalService } from 'src/app/services/apuracaofiscal.service';
import { ElementDialogComponent } from 'src/app/shared/element-dialog/element-dialog.component';
import { BucketDownloadPDFService } from '../services/bucket.service';
import {formatDate} from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { dataMask } from "src/app/utils/dataMask"

@Component({
  selector: 'app-apuracao',
  templateUrl: './apuracao.component.html',
  styleUrls: ['./apuracao.component.scss'],
  providers: [ApuracaoFiscalService, BucketDownloadPDFService]
})


export class ApuracaoComponent implements OnInit {
  
  private updateSubscription!: Subscription;
  
  @ViewChild(MatTable)
  table!: MatTable<any>;
  amount!: any;
  mesano!: string;
  nomSistema!: string;
  nomFilial!: string;

  displayedColumns: string[] = [
                                'mesAnoCompetencia',
                                'nomeFilial',
                                'CodCnpj',
                                'valorTotalFaturaPref',
                                'valorBaseCalculoPref',
                                'valorTotalImpostoPref',
                                'valorTotalFaturaFatwin',
                                'valorBaseCalculoFatwin',
                                'valorTotalImpostoFatwin',
                                'valorTotalFaturaSynchro',
                                'valorBaseCalculoSynchro',
                                'valorTotalImpostoSynchro',
                                'totalNotasFatwin',
                                'totalNotasLivro',
                                'statusProcessamento' ,
                                'livroPDF',
                                'fatwinPDF',
                                'synchroPDF'                                                             
                                ];
                                
  dataSource!: ApuracaoFiscal[];
  
  constructor(
          public dialog: MatDialog,
          public apuracaoFiscalService: ApuracaoFiscalService,
          public bucketDownloadService: BucketDownloadPDFService,
          private router: Router,
          private toastrService: ToastrService
    ) {
        this.apuracaoFiscalService.obterListaFiliais(this.mesano).subscribe((data: ApuracaoFiscal[]) => {
              console.log(data);
              this.dataSource = data;
            });
  }


  ngDoCheck() {
    this.mesano = dataMask(this.mesano)
  }

  ngOnInit(): void {
      this.mesano = ''
      this.nomSistema = ''
      this.nomFilial = ''
      
      this.updateSubscription = interval(10000).subscribe(
          (val) => { this.apuracaoFiscalService.obterListaMesAnoFilial(this.mesano.replace("/", ""), this.nomFilial)
                      .subscribe((data: ApuracaoFiscal[]) => {
                        console.log(data);
                        this.dataSource = data;
                      });
      });
 
  }


  efetuarPerquisa(mesano: string, nomeFilial: string): void{
    console.log("Mẽs/ANO: " + mesano.replace("/", ""));
    this.apuracaoFiscalService.obterListaMesAnoFilial(mesano.replace("/", ""), nomeFilial).subscribe((data: ApuracaoFiscal[]) => {
      console.log(data);
      this.dataSource = data;
    });
  }

  
  downloadLivroFiscal(apuracao: ApuracaoFiscal): void {

    if(apuracao.totalNotasLivro === 0){
      this.toastrService.success('O arquivo não está disponível no momento, tente novamente mais tarde');
      return
    }
  
    this.bucketDownloadService.downloadLivroFiscal(apuracao.id).subscribe(
      (res: any)  => {

          this.downloadArquivo(res, apuracao.nomeFilial + "_livro_fiscal_" + apuracao.mesAnoCompetencia);

      }
    )
  }


  downloadEmissaoGuia(apuracao: ApuracaoFiscal): void {
    console.log("downloadEmissaoGuia(): " + apuracao.id);
    this.bucketDownloadService.downloadEmissaoGuia(apuracao.id).subscribe(
      (res: any)  => {

          this.downloadArquivo(res, apuracao.nomeFilial + "_emissao_guia_" + apuracao.mesAnoCompetencia);

      }
    )
  }


  downloadSynchro(element: ApuracaoFiscal): void {
    this.toastrService.success('Função em construção, tente novamente mais tarde');
    return
  }


  downloadArquivo(data: any, nomArquivo: string){
    const file = new Blob([data], {type: data.type});
    const blob = window.URL.createObjectURL(file);
    const link = document.createElement("a");
    link.href = blob; 
    link.download = nomArquivo + ".pdf";

    link.click();

    window.URL.revokeObjectURL(blob);
    link.remove();
  }


  logout(){
    this.router.navigate(['/']);
  }

}
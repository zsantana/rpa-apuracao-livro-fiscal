import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, mapTo, Observable, of, tap } from 'rxjs';
import { ApuracaoFiscal } from '../models/apuracaofiscal';
import { environment } from 'src/environments/environment';



@Injectable()
export class ApuracaoFiscalService {
  elementApiUrl = environment.api + '/v1/painel/';
  constructor(private http: HttpClient) { }



  obterListaFiliais(mesano: string): Observable<ApuracaoFiscal[]> {
     console.log("elementApiUrl: " + this.elementApiUrl);
     return this.http.get<ApuracaoFiscal[]>(this.elementApiUrl + 'apuracaosintetica/' + mesano,  {withCredentials: true});
  }

  obterListaMesAnoFilial(mesano: string, nomFilial: string): Observable<ApuracaoFiscal[]> {
    console.log("obterListaMesAnoFilial: " + this.elementApiUrl + 'apuracaosintetica/mesano/' + mesano + "/filial/" + nomFilial,);
    
    if (nomFilial){
      return this.http.get<ApuracaoFiscal[]>(this.elementApiUrl + 'apuracaosintetica/mesano/' + mesano + "/filial/" + nomFilial,  {withCredentials: true});
    }else{
      return this.obterListaFiliais(mesano);
    }
    
}

  downloadFile(element: ApuracaoFiscal): Observable<ApuracaoFiscal> {
    return this.http.put<ApuracaoFiscal>(this.elementApiUrl, element);
  }

}

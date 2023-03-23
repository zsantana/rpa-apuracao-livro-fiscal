import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Injectable()
export class BucketDownloadPDFService {
  elementApiUrl = environment.api + '/v1/bucket/download/';
  constructor(private http: HttpClient) { }

  downloadLivroFiscal(chaveBucket: string) {
    //console.log("BucketDownloadPDFService: " + this.elementApiUrl + 'livrofiscal/' + chaveBucket, {responseType: 'arraybuffer'});
    return this.http.get<any>(this.elementApiUrl + 'livrofiscal/' + chaveBucket, {responseType: 'blob' as 'json'});
  }

  downloadEmissaoGuia(chaveBucket: string) {
    //console.log("BucketDownloadPDFService: " + this.elementApiUrl + 'livrofiscal/' + chaveBucket, {responseType: 'arraybuffer'});
    return this.http.get<any>(this.elementApiUrl + 'emissaoguia/' + chaveBucket, {responseType: 'blob' as 'json'});
  }

  downloadSynchro(chaveBucket: string) {
    //console.log("BucketDownloadPDFService: " + this.elementApiUrl + 'livrofiscal/' + chaveBucket, {responseType: 'arraybuffer'});
    return this.http.get<any>(this.elementApiUrl + 'synchro/' + chaveBucket, {responseType: 'blob' as 'json'});
  }
  

}

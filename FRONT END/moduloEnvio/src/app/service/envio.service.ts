import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Envio } from '../models/envio';

@Injectable({
  providedIn: 'root',
})
export class EnvioService {
  protected baseEndPoint = 'http://localhost:8090/api/envios';

  protected cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(protected http: HttpClient) {}

  public listar(): Observable<Envio[]> {
    return this.http.get<Envio[]>(this.baseEndPoint);
  }

  public obterEnvioById(id: number): Observable<Envio> {
    return this.http.get<Envio>(`${this.baseEndPoint}/${id}`);
  }

  public obterEnvioByEstado(estado: number): Observable<Envio[]> {
    return this.http.get<Envio[]>(`${this.baseEndPoint}/estado/${estado}`);
  }

  public crearEnvio(envio: Envio) {
    return this.http
      .post(this.baseEndPoint, envio, { headers: this.cabeceras })
      .toPromise();
  }

  public modificarEnvio(envio: Envio) {
    return this.http.put(`${this.baseEndPoint}/${envio.idenvio}`, envio, {
      headers: this.cabeceras,
    });
  }

  public cancelarEnvio(envio: Envio) {
    return this.http.put(
      `${this.baseEndPoint}/cancelar/${envio.idenvio}`,
      envio,
      { headers: this.cabeceras }
    );
  }
}

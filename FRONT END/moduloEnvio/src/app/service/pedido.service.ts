import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, ObservedValueOf } from 'rxjs';
import { Pedido } from '../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  protected baseEndPoint = 'http://localhost:8090/api/pedidos';

  protected cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(protected http: HttpClient) { }

  public listar(): Observable<Pedido[]>{
    return this.http.get<Pedido[]>(this.baseEndPoint+'/pedidos');
  }

  public obterPedidoById(id:number): Observable<Pedido>{
    return this.http.get<Pedido>(`${this.baseEndPoint}/pedido/${id}`);
  }

  public actualizarPedido(pedido:Pedido,idEnvio?:number){
    return this.http.put(`${this.baseEndPoint}/pedido/${idEnvio}`,pedido,{headers: this.cabeceras});
  }

}

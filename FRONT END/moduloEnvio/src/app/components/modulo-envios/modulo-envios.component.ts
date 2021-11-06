import { Component, OnInit } from '@angular/core';
import { Envio } from 'src/app/models/envio';
import { EnvioService } from 'src/app/service/envio.service';

@Component({
  selector: 'modulo-envios',
  templateUrl: './modulo-envios.component.html',
  styleUrls: ['./modulo-envios.component.css'],
})
export class ModuloEnviosComponent implements OnInit {
  idPedido: any;

  IdEnvio:any;
  verCrearEnvio: boolean = false;
  verDatosPedido: boolean = false;
  verListarEnvios: boolean = false;
  verListarPedidos: boolean = false;
  verValidarEnvio: boolean = false;
  verDetallePedido: boolean = false;
  estado: any;
  constructor() {}

  ngOnInit(): void {}

  crearEnvio(event: any) {
    this.idPedido = event;
    this.onverCrearEnvio();
  }

  onverCrearEnvio() {
    this.verDetallePedido=false;
    this.verDatosPedido = false;
    this.verListarEnvios = false;
    this.verListarPedidos = false;
    this.verValidarEnvio = false;
    this.verCrearEnvio = true;
  }
  onverDatosPedido() {
    this.verDetallePedido=false;
    this.verCrearEnvio = false;
    this.verDatosPedido = true;
    this.verListarEnvios = false;
    this.verListarPedidos = false;
    this.verValidarEnvio = false;
  }

  onVerPorEstado(envio:any){
    this.IdEnvio=envio;
    if(envio.estado=='Validado'){
      this.onverDetallePedido();
    }else if(envio.estado=='Borrador'){
      this.onverValidarEnvio();
    }else if(envio == 'Listado'){
      this.onverListarEnvios('Borrador');
    }else if(envio= 'Validados'){
      this.onverListarEnvios('Validado');
    }
  }

  onverListarEnvios(event:any) {
    this.estado = event;
    this.verDetallePedido=false;
    this.verCrearEnvio = false;
    this.verDatosPedido = false;
    this.verListarEnvios = true;
    this.verListarPedidos = false;
    this.verValidarEnvio = false;
  }
  onverDetallePedido() {
    this.verDetallePedido=true;
    this.verCrearEnvio = false;
    this.verDatosPedido = false;
    this.verListarEnvios = false;
    this.verListarPedidos = false;
    this.verValidarEnvio = false;

  }
  onverListarPedidos() {
    this.verDetallePedido=false;
    this.verCrearEnvio = false;
    this.verDatosPedido = false;
    this.verListarEnvios = false;
    this.verListarPedidos = true;
    this.verValidarEnvio = false;
  }
  onverValidarEnvio() {
    this.verDetallePedido=false;
    this.verCrearEnvio = false;
    this.verDatosPedido = false;
    this.verListarEnvios = false;
    this.verListarPedidos = false;
    this.verValidarEnvio = true;
  }
}

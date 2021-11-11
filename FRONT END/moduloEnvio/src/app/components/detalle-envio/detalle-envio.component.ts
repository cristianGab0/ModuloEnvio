import { Component, Input, OnInit } from '@angular/core';
import { Envio } from 'src/app/models/envio';
import { Pedido } from 'src/app/models/pedido';
import { EnvioService } from 'src/app/service/envio.service';
import { PedidoService } from 'src/app/service/pedido.service';

@Component({
  selector: 'detalle-envio',
  templateUrl: './detalle-envio.component.html',
  styleUrls: ['./detalle-envio.component.css'],
})
export class DetalleEnvioComponent implements OnInit {
  servicioEnvio: EnvioService;
  servicioPedido: PedidoService;
  envio: Envio;
  pedido: Pedido;
  @Input() IdEnvio: any;

  constructor(service: EnvioService, servicePed: PedidoService) {
    this.servicioEnvio = service;
    this.servicioPedido = servicePed;
  }

  ngOnInit(): void {
    this.servicioEnvio.obterEnvioById(this.IdEnvio.idenvio).subscribe((e) => {
      this.envio = e;
      this.obtenerPedido(e['idPedido']);
    });
  }
  obtenerPedido(id: number) {
    this.servicioPedido.obterPedidoById(id).subscribe((p) => {
      this.pedido = p;
    });
  }
}

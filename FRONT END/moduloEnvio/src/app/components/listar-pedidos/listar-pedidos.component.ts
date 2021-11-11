import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/service/pedido.service';

@Component({
  selector: 'listar-pedidos',
  templateUrl: './listar-pedidos.component.html',
  styleUrls: ['./listar-pedidos.component.css'],
})
export class ListarPedidosComponent implements OnInit {
  servicioPedido: PedidoService;
  pedidos: Pedido[] = [];

  @Output() idPedido = new EventEmitter();

  constructor(service: PedidoService) {
    this.servicioPedido = service;
  }

  ngOnInit(): void {
    this.servicioPedido.listar().subscribe((p) => {
      this.pedidos = p;
      this.pedidos=this.pedidos.filter(p=>
        p.statusPedido==='Confirmado'
      )
    });
  }

  nuevoEnvio(id: number) {
    this.idPedido.emit(id);
  }
}

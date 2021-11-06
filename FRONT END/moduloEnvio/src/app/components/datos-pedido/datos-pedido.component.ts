import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/service/pedido.service';

@Component({
  selector: 'datos-pedido',
  templateUrl: './datos-pedido.component.html',
  styleUrls: ['./datos-pedido.component.css']
})
export class DatosPedidoComponent implements OnInit {
  servicio: PedidoService;
  pedido:Pedido;

  constructor(servicioPedido:PedidoService) {
    this.servicio = servicioPedido;
   }

  ngOnInit(): void {
    this.servicio.obterPedidoById(1).subscribe(p=>{
      this.pedido=p;
    })
  }
  crearEnvio(){

  }
}

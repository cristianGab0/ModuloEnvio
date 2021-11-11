import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Envio } from 'src/app/models/envio';
import { Pedido } from 'src/app/models/pedido';
import { EnvioService } from 'src/app/service/envio.service';
import { PedidoService } from 'src/app/service/pedido.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'validar-envio',
  templateUrl: './validar-envio.component.html',
  styleUrls: ['./validar-envio.component.css'],
})
export class ValidarEnvioComponent implements OnInit {
  servicioEnvio: EnvioService;
  servicioPedido: PedidoService;
  envio: Envio;
  pedido:Pedido;
  @Input() IdEnvio:Envio;
  @Output() verListadoBorrador = new EventEmitter();
  @Output() verListadoValidado = new EventEmitter();

  constructor(service: EnvioService, servicePed:PedidoService) {
    this.servicioEnvio = service;
    this.servicioPedido = servicePed;
  }

  ngOnInit(): void {
    this.servicioEnvio.obterEnvioById(this.IdEnvio.idenvio).subscribe((e) => {
      this.envio = e;
      this.obtenerPedido(e['idPedido']);
    });
  }

  obtenerPedido(id:number){

    this.servicioPedido.obterPedidoById(id).subscribe(p=>{
      this.pedido=p;
    })
  }

  async validar(){
    this.envio.estado='Validado';
    this.servicioEnvio.modificarEnvio(this.envio).subscribe();
    this.pedido.statusPedido='Envio Validado';
    this.servicioPedido.actualizarPedido(this.pedido,this.envio.idenvio).subscribe();

    await Swal.fire(
      '',
      `El envío ${this.envio.idenvio} ha sido validado.`,
      'success'
    );
    this.verListadoValidado.emit();
  }

  async eliminar(){
    this.envio.estado='Cancelado';
    this.servicioEnvio.cancelarEnvio(this.envio).subscribe();
    this.pedido.statusPedido='Confirmado';
    this.servicioPedido.actualizarPedido(this.pedido,this.envio.idenvio).subscribe();


    await Swal.fire({
      title: '¿Está seguro de eliminar el envío?',
      text: "",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText:'No'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          '',
          'El envío ha sido eliminado',
          'success'
        )
      }
    })

    this.verListadoBorrador.emit();

  }
}

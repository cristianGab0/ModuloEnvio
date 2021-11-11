import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Envio } from 'src/app/models/envio';
import { EnvioService } from 'src/app/service/envio.service';
import { PedidoService } from 'src/app/service/pedido.service';

@Component({
  selector: 'listar-envios',
  templateUrl: './listar-envios.component.html',
  styleUrls: ['./listar-envios.component.css'],
})
export class ListarEnviosComponent implements OnInit {
  servicioEnvio: EnvioService;
  servicioPedido: PedidoService;
  envios: Envio[] = [];


  @Input() Estado: any;
  @Output() verDatosPedidos = new EventEmitter();
  @Output() validarPedido = new EventEmitter();

  constructor(service: EnvioService, serviceP:PedidoService) {
    this.servicioEnvio = service;
    this.servicioPedido=serviceP;
  }

  onverDatosPedidos(envio:Envio) {
    if(envio.estado === 'Borrador'){

    }else if(envio.estado === 'Validado'){

    }else if(envio.estado === 'Procesado'){

    }
    this.verDatosPedidos.emit(envio);
  }
  ngOnInit(): void {}

  ngOnChanges(changes: SimpleChanges) {
    this.servicioEnvio.obterEnvioByEstado(this.Estado).subscribe((e) => {
      this.envios = e as Envio[];
      this.envios.map(envio=>{
        this.servicioPedido.obterPedidoById(envio.idPedido).subscribe(
          p=>{
            return envio.nombreCliente = p.nombreCliente
          }
        );
      });
    });
  }
}

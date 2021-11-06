import { ConstantPool } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DetallePedidoId } from 'src/app/models/detalle-pedido-id';
import { Envio } from 'src/app/models/envio';
import { Pedido } from 'src/app/models/pedido';
import { EnvioService } from 'src/app/service/envio.service';
import { PedidoService } from 'src/app/service/pedido.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'crear-envio',
  templateUrl: './crear-envio.component.html',
  styleUrls: ['./crear-envio.component.css'],
})
export class CrearEnvioComponent implements OnInit {
  @Input() idPedido: any;
  @Output() verPedidos = new EventEmitter();
  @Output() verEnvios = new EventEmitter();
  servicioEnvio: EnvioService;
  servicioPedido: PedidoService;
  envio: Envio = new Envio();
  pedido: Pedido;
  pedidoActualizado: Pedido;
  fecha: Date;
  public formDatosEnvio = new FormGroup({
    fechaEntrega: new FormControl(null, Validators.required),
    nota: new FormControl(),
    direccion: new FormControl(null, Validators.required),
    peso: new FormControl(null, Validators.required),
    largo: new FormControl(null, Validators.required),
    alto: new FormControl(null, Validators.required),
    fondo: new FormControl(null, Validators.required),
    numeroSeguimiento: new FormControl(null, Validators.required),
  });
  tipoPeso = [
    { id: 1, desc: 'tonelada' },
    { id: 2, desc: 'Kg' },
    { id: 3, desc: 'g' },
    { id: 4, desc: 'mg' },
    { id: 5, desc: 'onza' },
    { id: 6, desc: 'libra' },
  ];

  tipoDimension = [
    { id: 1, desc: 'm' },
    { id: 2, desc: 'dm' },
    { id: 3, desc: 'dm' },
    { id: 4, desc: 'mm' },
    { id: 5, desc: 'pie' },
    { id: 6, desc: 'pulgada' },
  ];

  metodoEnvio = [{ name: 'GUATEX' }, { name: 'Cargo Expreso' }];

  constructor(service: EnvioService, servicePed: PedidoService) {
    this.servicioEnvio = service;
    this.servicioPedido = servicePed;
  }

  ngOnInit(): void {
    this.servicioPedido.obterPedidoById(this.idPedido).subscribe((p) => {
      this.pedido = p;
      this.pedidoActualizado = JSON.parse(JSON.stringify(p));
    });
  }

  seleccionarTipoPeso(id: number) {
    this.envio.tipo_peso = id;
    // this.formDatosEnvio.controls.tipoPesoInput.setValue=id as any;
  }
  seleccionarTipoDimension(id: number) {
    this.envio.tipo_dimension = id;
    // this.formDatosEnvio.controls.tipoDimensionInput.setValue=id as any;
  }
  seleccionarMetodoEnvio(opcion: string) {
    this.envio.metodoEnvio = opcion;
    // this.formDatosEnvio.controls.metodoEnvioInput.setValue=opcion as any;
  }

  seleccionarCantidadEnviar(detalle: DetallePedidoId, event: any) {
    let cantidad = event.target.value as number;
    this.pedidoActualizado.detallePedidos.forEach((det) => {
      if (
        det.id.idPedido == detalle.idPedido &&
        det.id.idProducto == detalle.idProducto
      ) {
        det.cantidadEnviada = cantidad;
      }
    });
  }

  validForm() {
    return (
      this.formDatosEnvio.valid &&
      this.envio.tipo_dimension != null &&
      this.envio.tipo_peso != null &&
      this.envio.metodoEnvio != null
    );
  }

  async crearEnvio() {
    let esMayor: boolean = true;
    this.pedidoActualizado.detallePedidos.forEach((d) => {
      if (d.cantidadPedida < d.cantidadEnviada) {
        esMayor = false;
      }
    });
    if (esMayor) {
      this.envio.alto = this.formDatosEnvio.controls.alto.value
      this.envio.direccion = this.formDatosEnvio.controls.direccion.value
      this.envio.fechaEntrega = this.formDatosEnvio.controls.fechaEntrega.value
      this.envio.fondo = this.formDatosEnvio.controls.fondo.value
      this.envio.largo = this.formDatosEnvio.controls.largo.value
      this.envio.nota = this.formDatosEnvio.controls.nota.value
      this.envio.numeroSeguimiento = this.formDatosEnvio.controls.numeroSeguimiento.value
      this.envio.peso = this.formDatosEnvio.controls.peso.value

      this.envio.estado = 'Borrador';
      this.envio.idPedido = this.pedido.idpedido;
      await this.servicioEnvio.crearEnvio(this.envio).then((e) => {
        this.envio = e as Envio;
      });
      this.pedidoActualizado.statusPedido = 'Envio en Borrador';
      this.servicioPedido
        .actualizarPedido(this.pedidoActualizado, this.envio.idenvio)
        .subscribe();
      await Swal.fire(
        'Envío creado:',
        `El envío No. ${this.envio.idenvio} se creó con éxito`,
        'success'
      );
      this.verEnvios.emit();
    } else {
      await Swal.fire(
        '',
        `La cantidad a enviar no puede ser mayor a la cantidad pedida`,
        'error'
      );
    }
  }

  anularEnvio() {
    this.verPedidos.emit();
  }
}

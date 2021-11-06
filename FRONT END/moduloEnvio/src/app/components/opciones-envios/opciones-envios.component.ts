import { Component, EventEmitter, OnInit,Output } from '@angular/core';

@Component({
  selector: 'opciones-envios',
  templateUrl: './opciones-envios.component.html',
  styleUrls: ['./opciones-envios.component.css']
})
export class OpcionesEnviosComponent implements OnInit {
  verListado:boolean=false;
  @Output()
  verListarPedido =  new EventEmitter();
  @Output()
  verListadoEnvios =  new EventEmitter();
  @Output()
  verListadoPedidos =  new EventEmitter();
  constructor() { }

  ngOnInit(): void {

  }

  onListadoEnvios(estado:any){
    this.verListadoEnvios.emit(estado);
  }

  onListadoPedidos(){
    this.verListarPedido.emit();
  }


}

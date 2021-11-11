import { DetallePedido } from "./detalle-pedido";

export class Pedido {
  idpedido: number;
  nombreCliente:string;
  fechaPedido: Date;
  statusPedido: string;
  detallePedidos: DetallePedido[]=[];
  montoTotal:number;
}

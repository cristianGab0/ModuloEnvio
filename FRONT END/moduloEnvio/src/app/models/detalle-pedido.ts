import { DetallePedidoId } from './detalle-pedido-id';
import { Producto } from './producto';

export class DetallePedido {
  id: DetallePedidoId;
  producto: Producto;
  cantidadEnviada: number;
  cantidadPedida: number;
}

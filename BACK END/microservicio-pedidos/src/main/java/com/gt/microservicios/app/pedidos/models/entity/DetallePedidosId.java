package com.gt.microservicios.app.pedidos.models.entity;
// Generated 13/10/2021 09:14:55 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DetallePedidosId generated by hbm2java
 */
@Embeddable
public class DetallePedidosId  implements java.io.Serializable {


     private long idPedido;
     private long idProducto;

    public DetallePedidosId() {
    }

    public DetallePedidosId(long idPedido, long idProducto) {
       this.idPedido = idPedido;
       this.idProducto = idProducto;
    }
   


    @Column(name="id_pedido", nullable=false)
    public long getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }


    @Column(name="id_producto", nullable=false)
    public long getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetallePedidosId) ) return false;
		 DetallePedidosId castOther = ( DetallePedidosId ) other; 
         
		 return (this.getIdPedido()==castOther.getIdPedido())
 && (this.getIdProducto()==castOther.getIdProducto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdPedido();
         result = 37 * result + (int) this.getIdProducto();
         return result;
   }   


}



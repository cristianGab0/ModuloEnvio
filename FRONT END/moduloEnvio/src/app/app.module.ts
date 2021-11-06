import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModuloEnviosComponent } from './components/modulo-envios/modulo-envios.component';
import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OpcionesEnviosComponent } from './components/opciones-envios/opciones-envios.component';
import { DatosPedidoComponent } from './components/datos-pedido/datos-pedido.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CrearEnvioComponent } from './components/crear-envio/crear-envio.component';
import { ValidarEnvioComponent } from './components/validar-envio/validar-envio.component';
import { ListarEnviosComponent } from './components/listar-envios/listar-envios.component';
import { ListarPedidosComponent } from './components/listar-pedidos/listar-pedidos.component';
import { HttpClientModule } from '@angular/common/http';
import { DetalleEnvioComponent } from './components/detalle-envio/detalle-envio.component';
@NgModule({
  declarations: [
    AppComponent,
    ModuloEnviosComponent,
    OpcionesEnviosComponent,
    DatosPedidoComponent,
    CrearEnvioComponent,
    ValidarEnvioComponent,
    ListarEnviosComponent,
    ListarPedidosComponent,
    DetalleEnvioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FontAwesomeModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

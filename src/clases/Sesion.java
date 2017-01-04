/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.*;

/**
 *
 * @author scami
 */
public class Sesion {
    
protected final int Demanda; //La demanda diaria y  
    //su probabilidad
protected final int TiempoEntrega; //Tiempo de entrega y 
    //su probabilidad
protected final int TiempoCliente; //El tiempo de espera  
    //del cliente por el artículo y su probabilidad
protected final double CostoInvent; //Costo de inventario = $ unidad/año
protected final double CostoOrden; //Costo de ordenar = $ / orden
protected final double CostoConEspera; //Costo de faltante con espera de cliente 
protected final double CostoSinEspera; //Costo de faltante sin espera de cliente 
protected final int InvInicial; // Inventario inicial
protected final int dia; // Cantidad de días a simular

    public Sesion(int Demanda, int TiempoEntrega, int TiempoCliente, double CostoInvent, double CostoOrden, double CostoConEspera, double CostoSinEspera, int InvInicial, int dia) {
        this.Demanda = Demanda;
        this.TiempoEntrega = TiempoEntrega;
        this.TiempoCliente = TiempoCliente;
        this.CostoInvent = CostoInvent;
        this.CostoOrden = CostoOrden;
        this.CostoConEspera = CostoConEspera;
        this.CostoSinEspera = CostoSinEspera;
        this.InvInicial = InvInicial;
        this.dia = dia;
    }
    
    
    public Sesion(int j) {
        this.Demanda = 10;
        this.TiempoEntrega = 2;
        this.TiempoCliente = 2;
        this.CostoInvent = 100;
        this.CostoOrden = 20;
        this.CostoConEspera = 25;
        this.CostoSinEspera = 30;
        this.InvInicial = 50;
        this.dia = j;
    }

}

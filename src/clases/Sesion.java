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
    
protected final ArrayList<Integer> Demanda; //La demanda diaria y  
    //su probabilidad
protected final ArrayList<Integer> TiempoEntrega; //Tiempo de entrega y 
    //su probabilidad
protected final ArrayList<Integer> TiempoCliente; //El tiempo de espera  
    //del cliente por el artículo y su probabilidad
protected final double CostoInvent; //Costo de inventario = $ unidad/año
protected final double CostoOrden; //Costo de ordenar = $ / orden
protected final double CostoConEspera; //Costo de faltante con espera de cliente 
protected final double CostoSinEspera; //Costo de faltante sin espera de cliente 
protected final int InvInicial; // Inventario inicial
protected final int dias; // Cantidad de días a simular


    public Sesion(ArrayList<Integer> Demanda, ArrayList<Integer> TiempoEntrega, 
            ArrayList<Integer> TiempoCliente, double CostoInvent, 
                double CostoOrden, double CostoConEspera, double CostoSinEspera, 
                    int InvInicial, int dias) {
        this.Demanda = Demanda;
        this.TiempoEntrega = TiempoEntrega;
        this.TiempoCliente = TiempoCliente;
        this.CostoInvent = CostoInvent;
        this.CostoOrden = CostoOrden;
        this.CostoConEspera = CostoConEspera;
        this.CostoSinEspera = CostoSinEspera;
        this.InvInicial = InvInicial;
        this.dias = dias;
    }






}

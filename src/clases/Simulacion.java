/*
 * Copyright (C) 2016 scami
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package clases;

import java.util.ArrayList;

/**
 *
 * @author scami
 */
public class Simulacion  {
    
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
public final int dia; // Cantidad de días a simular
public ArrayList <Simulacion> simulacion;
    
    
   
    
    public Simulacion(int Demanda, int TiempoEntrega, int TiempoCliente, 
            double CostoInvent, double CostoOrden, double CostoConEspera, 
                double CostoSinEspera, int InvInicial, int dia) {
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
    
    public Simulacion(int j) {
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
    
    public void init() {
        simulacion = new ArrayList<Simulacion>();
        simulacion.clear();
        
        for (int i = 1; i < 100000; i++){
            simulacion.add(new Simulacion(i));
        }
    }
    
    
    


    

    @Override
    public boolean equals(Object  obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Simulacion)) return false;
    Simulacion o = (Simulacion) obj;
    return o.dia == this.dia;
}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.dia;
        return hash;
    }

    
}



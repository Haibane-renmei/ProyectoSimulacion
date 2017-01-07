/*
 * Copyright (C) 2017 scami
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
public class Simulacion {

public ArrayList<Dia> simulacion;
    
private final int InvInicial; // Inventario inicial
private final int dias; // Cantidad de días a simular
private final double CostoInvent; //Costo de inventario = $ unidad/año
private final double CostoOrden; //Costo de ordenar = $ / orden
private final double CostoConEspera; //Costo de faltante con espera de cliente 
private final double CostoSinEspera; //Costo de faltante sin espera de cliente
private final int puntoReorden;
private final int cantidadPedido;

    public Simulacion(int InvInicial, int dias, double CostoInvent, 
            double CostoOrden, double CostoConEspera, double CostoSinEspera, 
                int puntoReorden, int cantidadPedido) {
        this.InvInicial = InvInicial;
        this.dias = dias;
        this.CostoInvent = CostoInvent;
        this.CostoOrden = CostoOrden;
        this.CostoConEspera = CostoConEspera;
        this.CostoSinEspera = CostoSinEspera;
        this.puntoReorden = puntoReorden;
        this.cantidadPedido = cantidadPedido;
    }


    
}

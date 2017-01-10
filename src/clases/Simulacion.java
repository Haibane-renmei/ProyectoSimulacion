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

public ArrayList<SimulacionDias> simulacion;
public Random aleatorio;
    
private final int invInicial; // Inventario inicial
private final int dias; // Cantidad de días a simular
private final double costoInvent; //Costo de inventario = $ unidad/año
private final double costoOrden; //Costo de ordenar = $ / orden
private final double costoConEspera; //Costo de faltante con espera de cliente 
private final double costoSinEspera; //Costo de faltante sin espera de cliente
private int puntoReordenOp; // Punto de reorden optimo de la simulacion
private int cantidadPedidoOp; // Cantidad de pedido optimo de la simulacion
private double costoTotalOp; // Costo total optimo de la simulacion
private int prmin ; // Punto de reorden minimo de la simulacion
private int prmax; // Punto de reorden maximo de la simulacion
private int qmin; // Cantidad de pedido minimo de la simulacion
private int qmax; // Cantidad de pedido maximo de la simulacion




    public Simulacion() {
        this.invInicial = 50;
        this.dias = 70;
        this.costoInvent = 52;
        this.costoOrden = 100;
        this.costoConEspera = 20;
        this.costoSinEspera = 50;
        this.aleatorio = new Random(13, 31);
        this.simulacion = new ArrayList<>();
        this.costoTotalOp = 999999999;
    }

    public Simulacion(int InvInicial, int dias, double CostoInvent, 
            double CostoOrden, double CostoConEspera, double CostoSinEspera) {
        this.invInicial = (int)InvInicial;
        this.dias = (int)dias;
        this.costoInvent = CostoInvent;
        this.costoOrden = CostoOrden;
        this.costoConEspera = CostoConEspera;
        this.costoSinEspera = CostoSinEspera;
        this.aleatorio = new Random(13, 31);
        this.simulacion = new ArrayList<>();
        this.costoTotalOp = 999999999;
        this.prmin = 999999999;
        this.qmin = 999999999;
        this.prmax = 0;
        this.qmax = 0;
    }
    
    // Itera todas las combinaciones de Q y PR, y obtiene sus valores optimos
    public void iterarDias() {
        int i = 0;

        for (Integer[] demandas: aleatorio.getDemanda()) {
            for (Integer[] tiempo: aleatorio.getTiempoEntrega()){
                double Q = Math.sqrt((2 * costoOrden * demandas[0] * 365) / 
                        (costoInvent));
                int PR = demandas[0] * tiempo[0];
                
                if (PR < prmin) {
                    prmin = PR;
                }
                if (PR > prmax) {
                    prmax = PR;
                }
                
                if (Q < qmin) {
                    qmin = (int)Q;
                }
                if (Q > qmax) {
                    qmax = (int)Q;
                }
                
                simulacion.add(new SimulacionDias(aleatorio, PR, (int)Q, 
                        costoInvent, costoOrden, costoConEspera, costoSinEspera, 
                        invInicial, dias));
                this.simulacion.get(i).iterar();
                
                if (simulacion.get(i).costoTotal < costoTotalOp) {
                    costoTotalOp = simulacion.get(i).costoTotal;
                    puntoReordenOp = simulacion.get(i).puntoReorden;
                    cantidadPedidoOp = simulacion.get(i).cantidadPedido;
                }
                i++;
            }
        }     
    }

    public int getPrmin() {
        return prmin;
    }

    public int getPrmax() {
        return prmax;
    }

    public int getQmin() {
        return qmin;
    }

    public int getQmax() {
        return qmax;
    }
    
    public int getPuntoReordenOp() {
        return puntoReordenOp;
    }

    public int getCantidadPedidoOp() {
        return cantidadPedidoOp;
    }

    public double getCostoTotalOp() {
        return costoTotalOp;
    }
    
}

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
import java.util.Arrays;

/**
 *
 * @author scami
 */
public class SimulacionDias  {

public Random Aleatorio;
public ArrayList <Integer[]> simDia; // Simulacion por dia
public ArrayList <Integer[]> colaFaltante; // Lista de compras que fueron 
    //esperadas y cuales fueron exitosas

/**
Representacion de el arreglo simDia
 0 Día
 1 Inv Inc.
 2 No. aleatorio para demanda
 3 Demanda
 4 Inv. Final
 5 Inv. Prom
 6 Faltante
 7 No.Orden
 8 No. aleatoriopara tiempo deentrega
 9 Tiempo de entrega
 10 No. aleatorio para tiempo de espera
 11 Tiempo de espera
 12 cliente espero

**/
public final int puntoReorden; // Punto de reorden asosiado a la combinacion
public final int cantidadPedido; // Cantidad de pedido asosiado a la combinacion

public double costoInv; // Costo de inventario total
public double costoOrdenes; // Costo de ordenes total
public double costoPerdidas; // Costo de perdidas total
public double costoTotal; // Costo total

private final double costoInvent; //Costo de inventario = $ unidad/año
private final double costoOrden; //Costo de ordenar = $ / orden
private final double costoConEspera; //Costo de faltante con espera de cliente 
private final double costoSinEspera; //Costo de faltante sin espera de cliente
private final int invInicial; // Inventario inicial
private final int dias; // Dias a simular

    public SimulacionDias(Random Aleatorio, int puntoReorden, 
            int cantidadPedido, double CostoInvent, double CostoOrden, 
                double CostoConEspera, double CostoSinEspera, int InvInicial, 
                    int dias) {
        this.Aleatorio = Aleatorio;
        this.puntoReorden = puntoReorden;
        this.cantidadPedido = cantidadPedido;
        this.costoInvent = CostoInvent;
        this.costoOrden = CostoOrden;
        this.costoConEspera = CostoConEspera;
        this.costoSinEspera = CostoSinEspera;
        this.invInicial = InvInicial;
        this.dias = dias;
        this.Aleatorio = Aleatorio;
        this.simDia = new ArrayList<>();
        this.colaFaltante = new ArrayList<>();
        this.costoInv = 0;
        this.costoOrdenes = 0;
        this.costoPerdidas = 0;
        this.costoTotal = 0;
    }





    
    // Itera todos los dias de una combinacion de Q y PR
    public void iterar() {
        Integer[] TempSimulacion = new Integer[14];
        int siguienteEntrega = 0;
        int dia = 1;
        int ordenes = 0;
        int faltantes = 0;
        
        while (dia <= dias) {
            
            TempSimulacion[0] = dia;
            if (dia == 1){
                TempSimulacion[1] = invInicial;
            } else {
                TempSimulacion[1] = simDia.get(dia-2)[4];
            }
             if (siguienteEntrega == dia) {
                TempSimulacion[1] = TempSimulacion[1] + cantidadPedido;
            }
            if (colaFaltante.isEmpty()) {
                for (Integer[] faltante: colaFaltante) {
                    if (faltante[0] < TempSimulacion[1] && faltante[1] <= dia 
                            && faltante[2] == 0){
                        TempSimulacion[1] =  TempSimulacion[1] - 
                                colaFaltante.get(0)[0];
                        faltantes = faltantes - colaFaltante.get(0)[0];
                        faltante[2] = 1;
                    }
                }   
            }
            
            TempSimulacion[2] = (int) Aleatorio.getRandom();
            TempSimulacion[3] = (int) Aleatorio.getNumDemanda(
                    TempSimulacion[2]);
            if (TempSimulacion[1] - TempSimulacion[3] >= 0) {
                TempSimulacion[4] = TempSimulacion[1] - TempSimulacion[3];
            } else {
                TempSimulacion[4] = 0;
                TempSimulacion[10] = (int)Aleatorio.getRandom();
                TempSimulacion[11] = Aleatorio.getNumEspCliente(
                        TempSimulacion[10]);
                faltantes = faltantes + TempSimulacion[3] - TempSimulacion[1];
                TempSimulacion[6] = faltantes;
                Integer[] temp = new Integer[3];
                temp[0] = TempSimulacion[6];
                temp[1] = dia + TempSimulacion[11];
                temp[2] = 0;
                colaFaltante.add(temp);
            }
            TempSimulacion[5] = (TempSimulacion[1] + TempSimulacion[4]) / 2;
            
            if (TempSimulacion[4] < puntoReorden && siguienteEntrega < dia) {
                TempSimulacion[7] = ++ordenes;
                TempSimulacion[8] = (int)Aleatorio.getRandom();
                TempSimulacion[9] = 
                    (int)Aleatorio.getNumEspEntrega(TempSimulacion[8]);
                siguienteEntrega = TempSimulacion[9] + dia + 1;
            }
            simDia.add(TempSimulacion.clone());
            Arrays.fill(TempSimulacion, null);
            dia++;
        }
        
        for (Integer[] temp: simDia) {
            costoInv = (double) (costoInv + temp[5] * costoInvent/365);
        }
        for (Integer[] temp: colaFaltante) {
            if (temp[2] == 0) {costoPerdidas = costoPerdidas + temp[0] * 
                    costoSinEspera;}
            if (temp[2] == 1) {costoPerdidas = costoPerdidas + temp[0] * 
                    costoConEspera;}
        }
        costoOrdenes = ordenes * costoOrden;
        
        costoTotal = costoInv + costoOrdenes + costoPerdidas;  
    }
    

    public int getPuntoReorden() {
        return puntoReorden;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public double getCostoInv() {
        return costoInv;
    }

    public double getCostoOrdenes() {
        return costoOrdenes;
    }

    public double getCostoPerdidas() {
        return costoPerdidas;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

}


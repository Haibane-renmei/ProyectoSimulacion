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
public class Dia  {

public Random Aleatorio;
public ArrayList <Integer[]> simulacion;
public ArrayList <Integer[]> colaEspera;
public ArrayList <Integer[]> colaFaltante;

private final int puntoReorden;
private final int cantidadPedido;
private final int InvInicial; // Inventario inicial
private final int dias; // Cantidad de días a simular
private final double CostoInvent; //Costo de inventario = $ unidad/año
private final double CostoOrden; //Costo de ordenar = $ / orden
private final double CostoConEspera; //Costo de faltante con espera de cliente 
private final double CostoSinEspera; //Costo de faltante sin espera de cliente




    public Dia(){
        this.CostoInvent = -1;
        this.CostoOrden = -1;
        this.CostoConEspera = -1;
        this.CostoSinEspera = -1;
        this.InvInicial = -1;
        this.dias = 1;
        puntoReorden = -1;
        cantidadPedido = -1;
        this.Aleatorio = new Random(13, 31);
        simulacion = new ArrayList<Integer[]>();
        colaEspera = new ArrayList<Integer[]>();
        colaFaltante = new ArrayList<Integer[]>();
    }

    public Dia(int InvInicial, int dias, double CostoInvent, 
            double CostoOrden, double CostoConEspera, double CostoSinEspera) {
        this.InvInicial = InvInicial;
        this.dias = dias;
        this.CostoInvent = CostoInvent;
        this.CostoOrden = CostoOrden;
        this.CostoConEspera = CostoConEspera;
        this.CostoSinEspera = CostoSinEspera;
        puntoReorden = -1;
        cantidadPedido = -1;
        this.Aleatorio = new Random(13, 31);
        simulacion = new ArrayList<Integer[]>();
        colaEspera = new ArrayList<Integer[]>();
        colaFaltante = new ArrayList<Integer[]>();
    }
    
    
    public void iterar() {
        Integer[] TempSimulacion = new Integer[14];
        Integer[] TempColaFaltante = new Integer[4];
        int siguienteEntrega = 0;
        int dia = 1;
        
        while (dia < dias) {
        if (dia == 1){
            TempSimulacion[0] = 1;
            TempSimulacion[1] = InvInicial;
            TempSimulacion[2] = (int) Aleatorio.getRandom();
            TempSimulacion[3] = (int) Aleatorio.getDemanda(TempSimulacion[2]);
            if (TempSimulacion[1] - TempSimulacion[3] > 0) {
                TempSimulacion[4] = TempSimulacion[1] - TempSimulacion[3];
            } else {
                TempSimulacion[4] = 0;
                TempSimulacion[6] =  TempSimulacion[3] - TempSimulacion[1];
            }
            TempSimulacion[5] = (TempSimulacion[1] + TempSimulacion[4]) / 2;
            if (TempSimulacion[4] < puntoReorden && siguienteEntrega < dia) {
                TempSimulacion[7] = TempSimulacion[7]++;
                TempSimulacion[8] = (int)Aleatorio.getRandom();
                TempSimulacion[9] = 
                    (int)Aleatorio.getEspEntrega(TempSimulacion[8]);
                siguienteEntrega = TempSimulacion[9] + dia;  
            }
        } else {
            TempSimulacion[0] = dia;
            TempSimulacion[1] = simulacion.get(dia-1)[4];
            if (siguienteEntrega == dia) {
                TempSimulacion[1] = TempSimulacion[1] + cantidadPedido;
            }
            TempSimulacion[2] = (int) Aleatorio.getRandom();
            TempSimulacion[3] = (int) Aleatorio.getDemanda(TempSimulacion[2]);
            if (TempSimulacion[1] - TempSimulacion[3] > 0) {
                TempSimulacion[4] = TempSimulacion[1] - TempSimulacion[3];
            } else {
                TempSimulacion[4] = 0;
                TempSimulacion[6] =  TempSimulacion[3] - TempSimulacion[1];
            }
            TempSimulacion[5] = (TempSimulacion[1] + TempSimulacion[4]) / 2;
            if (TempSimulacion[4] < puntoReorden && siguienteEntrega < dia) {
                TempSimulacion[7] = TempSimulacion[7]++;
                TempSimulacion[8] = (int)Aleatorio.getRandom();
                TempSimulacion[9] = 
                    (int)Aleatorio.getEspEntrega(TempSimulacion[8]);
                siguienteEntrega = TempSimulacion[9] + dia;
            }
        }
        simulacion.add(dia, TempSimulacion);
        dia++;
        }
    }
        
        
    
    }
    



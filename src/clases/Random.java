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
public class Random {
    
    // Variables
    
    private byte NumAleatorio;  // Numero aleatorio generado
    private final int CONSTANTE_A;   // Constante 1 de formula
    private final int CONSTANTE_B;   // Constante 2 de formula
    public final ArrayList <Integer[]> Demanda; //La demanda diaria y  
    //su probabilidad
public final ArrayList <Integer[]> TiempoEntrega; //Tiempo de entrega y 
    //su probabilidad
public final ArrayList <Integer[]> TiempoCliente; //El tiempo de espera  
    //del cliente por el artículo y su probabilidad
    
    // Inicializador

    public Random(int CONSTANTE_A, int CONSTANTE_B) {
        this.NumAleatorio = 0;
        this.CONSTANTE_A = CONSTANTE_A;
        this.CONSTANTE_B = CONSTANTE_B;
        this.Demanda = new ArrayList<Integer[]>();
        this.TiempoCliente = new ArrayList<Integer[]>();
        this.TiempoEntrega = new ArrayList<Integer[]>();
    }
            
    
    
    // Metodos
    
    public byte getRandom() {
        NumAleatorio = (byte)((CONSTANTE_A * NumAleatorio + CONSTANTE_B) % 100);
        return NumAleatorio;
    }
    
    public void insDemanda(int a, float b) {
        Integer[] temp = new Integer[2];
        temp[0] = a;
        if (b < 1) {
            temp[1] = Math.round(b * 100);
        } else {
            temp[1] = Math.round(b);
        }
        
        Demanda.add(temp);
    }
    
    public void insEspCliente(int a, float b) {
        Integer[] temp = new Integer[2];
        temp[0] = a;
        if (b < 1) {
            temp[1] = Math.round(b * 100);
        } else {
            temp[1] = Math.round(b);
        }
        TiempoCliente.add(temp);
    }
    
    public void insEspEntrega(int a, float b) {
        Integer[] temp = new Integer[2];
        temp[0] = a;
        if (b < 1) {
            temp[1] = Math.round(b * 100);
        } else {
            temp[1] = Math.round(b);
        }
        TiempoEntrega.add(temp);
    }
    
    
     public int getDemanda(int alt) {
        Integer[] regla;
        Integer temp;
        Integer limite;
        
        temp = 0;
        regla = new Integer[100];
        
        for (Integer[] object: Demanda) {
            limite = temp;
            while (temp < limite + object[1]) {
                regla[temp++] = object[0];
                if (temp > 99) {break;}
            }
        }
        
        return regla[alt];
    }
    
    public int getEspCliente(int alt) {
        
        Integer[] regla;
        Integer temp;
        
        temp = 0;
        
        regla = new Integer[100];
        for (Integer[] object: TiempoCliente) {
            while (temp < temp + object[1]) {
                regla[temp++] = object[0];
                if (temp > 99) {break;}
            }
        }
        
        if (alt > 100 || alt < 0 || temp < 99) {
            return -1;
        }
        
        return regla[alt];

    }
    
    public int getEspEntrega(int alt) {
        
        Integer[] regla;
        Integer temp;
        
        temp = 0;
        
        regla = new Integer[100];
        for (Integer[] object: TiempoEntrega) {
            while (temp < temp + object[1]) {
                regla[temp++] = object[0];
                if (temp > 99) {break;}
            }
        }
        
        if (temp > 100) {
            return -1;
        }
        
        return regla[alt];

    }
    
    
    
    public void limpiar() {
        Demanda.clear();
        TiempoCliente.clear();
        TiempoEntrega.clear();
    }
    
}

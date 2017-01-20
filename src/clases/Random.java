/*
 * Copyright (C) 2016 scamil
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
public class Random {
    
    // Variables
    
    private static byte NumAleatorio;  // Numero aleatorio generado
    private static int CONSTANTE_A;   // Constante 1 de formula
    private static int CONSTANTE_B;   // Constante 2 de formula
    public  ArrayList <Integer[]> Demanda; //La demanda diaria y  
        //su probabilidad
    public  ArrayList <Integer[]> TiempoEntrega; //Tiempo de entrega y 
        //su probabilidad
    public  ArrayList <Integer[]> TiempoCliente; //El tiempo de espera  
        //del cliente por el artículo y su probabilidad
    
    // Inicializador

    public Random(int CONSTANTE_A, int CONSTANTE_B) {
        Random.CONSTANTE_A = CONSTANTE_A;
        Random.CONSTANTE_B = CONSTANTE_B;
        Demanda = new ArrayList<>();
        TiempoCliente = new ArrayList<>();
        TiempoEntrega = new ArrayList<>();
    }
            
    
    
    // Metodos
    
    // Genera y devuelve un numero aleatorio
    public byte getRandom() {
        NumAleatorio = (byte)((CONSTANTE_A * NumAleatorio + CONSTANTE_B) % 100);
        return NumAleatorio;
    }
    
    // Inserta una demanda y su posibilidad
    // Verifica que la posibilidad no sea 0 y que al agregar no supere el 100%
    public int insDemanda(int a, float b) {
        Integer[] temp = new Integer[2];
        temp[0] = a;
        if (b < 1) {
            temp[1] = Math.round(b * 100);
        } else {
            temp[1] = (int)b;
        }
        if (temp[1] > 0 && temp[1] <= 100 && esMenor(1, temp[1]) == 0) {
            Demanda.add(temp);
            return 0;
        }
        return 1;
    }
    
    // Inserta un tiempo espera de cliente y su posibilidad
    // Verifica que la posibilidad no sea 0 y que al agregar no supere el 100%
    public int insEspCliente(int a, float b) {
        Integer[] temp = new Integer[2];
        temp[0] = a;
        if (b < 1) {
            temp[1] = Math.round(b * 100);
        } else {
            temp[1] = (int)b;
        }
        
        if (temp[1] > 0 && temp[1] <= 100 && esMenor(3, temp[1]) == 0) {
            TiempoCliente.add(temp);
            return 0;
        }
        return 1;
    }
    
    // Inserta un tiempo de espera de entrega y su posibilidad
    // Verifica que la posibilidad no sea 0 y que al agregar no supere el 100%
    public int insEspEntrega(int a, float b) {
        Integer[] temp = new Integer[2];
        temp[0] = a;
        if (b < 1) {
            temp[1] = Math.round(b * 100);
        } else {
            temp[1] = (int)b;
        }
        if (temp[1] > 0 && temp[1] <= 100 && esMenor(2, temp[1]) == 0) {
            TiempoEntrega.add(temp);
            return 0;
        }
        return 1;
    }
    
    // Devuelve una demanda de acuerdo a su probabilidad
     public int getNumDemanda(int alt) {
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
    
     // Devuelve un timepo de espera de cliente de acuerdo a su probabilidad
    public int getNumEspCliente(int alt) {
        
        Integer[] regla;
        Integer temp;
        Integer limite;
        
        temp = 0;
        regla = new Integer[100];
        
        for (Integer[] object: TiempoCliente) {
            limite = temp;
            while (temp < limite + object[1]) {
                regla[temp++] = object[0];
                if (temp > 99) {break;}
            }
        }
        
        return regla[alt];

    }
    
    // Devuelve un tiempo de espera de entrega de acuerdo a su probabilidad
    public int getNumEspEntrega(int alt) {
        
        Integer[] regla;
        Integer temp;
        Integer limite;
        
        temp = 0;
        regla = new Integer[100];
        
        for (Integer[] object: TiempoEntrega) {
            limite = temp;
            while (temp < limite + object[1]) {
                regla[temp++] = object[0];
                if (temp > 99) {break;}
            }
        }
        
        return regla[alt];

    }
    
    // Verifica si todas las vaiables son correctas.
    // Cada variable de probabilidad debe sumar 100%
    public byte esCorrecto() {
        int check = 0;
        for (Integer[] object: Demanda) {
            check = check + object[1];
        }
        if (check != 100){
                return 1;
        }
        check = 0;
        for (Integer[] object: TiempoEntrega) {
            check = check + object[1];
        }
        if (check != 100){
                return 2;
        }
        check = 0;
        for (Integer[] object: TiempoCliente) {
            check = check + object[1];
        }
        if (check != 100){
                return 3;
        }
        return 0;
    }
    
        // Verifica si una tabla no supera el 100% de posibilidad.
        public byte esMenor(int i, int j) {
            int check = 0;
            switch (i) {
                case 1:
                    for (Integer[] object: Demanda) {
                        check = check + object[1];
                        if (check + j > 100){
                            return 1;}
                    }
                break;
                case 2:
                    for (Integer[] object: TiempoEntrega) {
                        check = check + object[1];
                        if (check + j > 100) 
                            return 1;
                }
                break;
                case 3:
                    for (Integer[] object: TiempoCliente) {
                        check = check + object[1];
                        if (check + j > 100)
                            return 1;
                }
                break;
                }
        return 0;
    }
        
    public void limpiar() {
        Demanda.clear();
        TiempoEntrega.clear();
        TiempoCliente.clear();
    }
    
    
    public ArrayList<Integer[]> getDemanda() {
        return Demanda;
    }

    public ArrayList<Integer[]> getTiempoEntrega() {
        return TiempoEntrega;
    }

    public ArrayList<Integer[]> getTiempoCliente() {
        return TiempoCliente;
    }
    
}

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
public class Simulacion extends Sesion {

    public Simulacion(ArrayList<Integer> Demanda, ArrayList<Integer> TiempoEntrega, ArrayList<Integer> TiempoCliente, double CostoInvent, double CostoOrden, double CostoConEspera, double CostoSinEspera, int InvInicial, int dias) {
        super(Demanda, TiempoEntrega, TiempoCliente, CostoInvent, CostoOrden, CostoConEspera, CostoSinEspera, InvInicial, dias);
    }

}

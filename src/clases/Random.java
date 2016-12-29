/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author scami
 */
public class Random {
    
    // Variables
    
    private byte NumAleatorio;  // Numero aleatorio generado
    private final int CONSTANTE_A;   // Constante 1 de formula
    private final int CONSTANTE_B;   // Constante 2 de formula
    
    // Inicializador

    public Random(int CONSTANTE_A, int CONSTANTE_B) {
        this.NumAleatorio = NumAleatorio;
        this.CONSTANTE_A = CONSTANTE_A;
        this.CONSTANTE_B = CONSTANTE_B;
    }
            
    
    
    // Metodos
    
    public byte getRandom() {
        NumAleatorio = (byte) ((CONSTANTE_A * NumAleatorio + CONSTANTE_B) % 100);
        return NumAleatorio;
    }
    
}

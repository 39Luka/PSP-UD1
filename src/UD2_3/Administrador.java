package UD2_3;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;

public class Administrador extends Thread{
    Tienda tienda;

    public Administrador(Tienda tienda){
        super();
        this.tienda = tienda;
    }

    @Override
    public void run() {
        Random random = new Random();
        int descuento = random.nextInt(1, 100);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Aplicando descuento...");
        tienda.aplicarDescuento(25); //Se ha puesto a 25 para que siempre sea 25% de descuento
                                    // pero si se pone el descuento sería aleatorio

    }
}

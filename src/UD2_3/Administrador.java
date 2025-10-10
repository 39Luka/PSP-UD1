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
        System.out.println("Aplicando descuento...");
        tienda.aplicarDescuento(25);

    }
}

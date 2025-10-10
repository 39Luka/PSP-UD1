package UD2_3;

import java.util.Random;

public class Cajero extends Thread {
    Tienda tienda;


    public Cajero(Tienda tienda){
        super();
        this.tienda = tienda;
    }

    @Override
    public void run() {
        Random random = new Random();
        int numTransacciones = random.nextInt(3,6);
        for (int i = 0; i < numTransacciones; i++) {
            int monto = random.nextInt(0, 101);
            System.out.println(Thread.currentThread().getName() +" monto: " + monto);
            tienda.agregarVenta(monto);
        }
    }
}

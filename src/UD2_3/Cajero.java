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

    }
}

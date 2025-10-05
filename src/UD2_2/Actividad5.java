package UD2_2;

import java.util.concurrent.ThreadLocalRandom;

import static UD2_2.Marcador.puntosTotales;

class Marcador extends Thread {
    public static int puntosTotales = 0;

    @Override
    public void run() {
        int puntos;
        String yo = Thread.currentThread().getName();
        for (int i = 0; i < 3; i++) { //Se añaden puentos 3 veces
            puntos = ThreadLocalRandom.current().nextInt(1, 11);
            agregarPuntos(puntos, yo);

        }
    }


    public void agregarPuntos(int puntos, String corredor) {
        if (puntosTotales < 50) { // Si no se ha llegado a 50 añaden (si varios leen que no hay 50 pueden añadir y llegar a la meta a la vez)
            puntosTotales += puntos;
            System.out.println(corredor + "ha agregado " + puntos + " punto/s.");
            if (puntosTotales >= 50) { //Si superan los 50 llegaron a la meta
                System.out.println(corredor + " llegue a la meta");
            }
        }
    }


}
public class Actividad5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Marcador(), "Marcador 1");
        Thread t2 = new Thread(new Marcador(), "Marcador 2");
        Thread t3 = new Thread(new Marcador(), "Marcador 3");
        Thread t4 = new Thread(new Marcador(), "Marcador 4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {// En main espera a que terminen los hilos para ver el resultado final del marcador
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Marcador: ");
        System.out.println(puntosTotales);
    }
}

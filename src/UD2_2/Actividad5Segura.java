package UD2_2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class MarcadorAtomico extends Thread{
    static AtomicInteger puntosTotales =  new AtomicInteger(0);


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
      boolean agregado = false;
      do {
          int puntosLeidos = puntosTotales.get();
          int puntosNuevos = puntosLeidos + puntos;
          if (puntosLeidos < 50) {
              agregado = puntosTotales.compareAndSet(puntosLeidos, puntosNuevos);
              System.out.println(corredor + "ha agregado " + puntos + " punto/s.");
              if (puntosNuevos >= 50){
                  System.out.println(corredor + " llegue a la meta");
              }
          }else{
              agregado = true;
          }
        }while (!agregado);
    }
}
public class Actividad5Segura {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MarcadorAtomico(), "Marcador 1");
        Thread t2 = new Thread(new MarcadorAtomico(), "Marcador 2");
        Thread t3 = new Thread(new MarcadorAtomico(), "Marcador 3");
        Thread t4 = new Thread(new MarcadorAtomico(), "Marcador 4");


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
        System.out.println(MarcadorAtomico.puntosTotales.get());
    }
}

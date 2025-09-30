package UD2_1;

public class Actividad8 {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            System.out.println("Hilo1: Empiezo");
                try {
                    while (true){
                    Thread.sleep(10000);}
                } catch (InterruptedException e) {
                    System.out.println("Hilo1: Interrumpido");
                    Thread.currentThread().interrupt();
                }


        });
        hilo1.start();
        Thread hilo2 = new Thread(() -> {
            try {
                System.out.println("Hilo2: Empiezo");

                hilo1.join();

                System.out.println("Hilo2: Termino");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        hilo2.start();

        Thread hilo3 = new Thread(hilo1::interrupt);
        hilo3.start();

    }
}

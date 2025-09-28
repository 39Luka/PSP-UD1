package UD2_1;

class Worker implements Runnable {

    String nombreHilo;

    Worker(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {

            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(getNombreHilo());
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println( getNombreHilo() + ": Interrumpido");
            }finally {
                System.out.println( getNombreHilo() +": Fin hilo");
            }


    }

    public String getNombreHilo() {
        return nombreHilo;
    }
}

public class Actividad9 {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker("Hilo1"));
        Thread t2 = new Thread(new Worker("Hilo2"));
        Thread t3 = new Thread(new Worker("Hilo3"));
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(700);
            t2.interrupt();

            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

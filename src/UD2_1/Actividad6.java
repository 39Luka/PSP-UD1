package UD2_1;
class HiloPorClase extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("El que extiende: Durmiendo...Zzzz");
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Actividad6 {
    public static void main(String[] args) {

        HiloPorClase hpc = new HiloPorClase();
        hpc.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    hpc.join();
                    System.out.println("Hola, soy el hilo runnable clásico");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread run = new Thread(runnable);
        run.start();

        Thread thread = new Thread(() -> {
            try {
                hpc.join();
                System.out.println("Hola, soy el hilo lambda");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();


    }
}

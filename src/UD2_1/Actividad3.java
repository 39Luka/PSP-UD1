package UD2_1;

class Hilo1 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
            try {
                Hilo.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Hilo2 extends Thread{
    Thread hiloEsperar;
    Hilo2(Thread hilo){
        hiloEsperar = hilo;
    }
    @Override
    public void run() {
        try {
            hiloEsperar.join();
            for (int i = 6; i < 11; i++) {
                System.out.println(i);
                try {
                    Hilo.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Hilo3 extends Thread{
    Thread hiloEsperar;
    Hilo3(Thread hilo){
        hiloEsperar = hilo;
    }

    @Override
    public void run() {
        try {
            hiloEsperar.join();
            for (int i = 11; i < 16; i++) {
                System.out.println(i);
                try {
                    Hilo.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class Actividad3 {
    public static void main(String[] args) {

        Hilo1 hilo1 = new Hilo1();
        hilo1.start();
        Hilo2 hilo2 = new Hilo2(hilo1);
        hilo2.start();
        Hilo3 hilo3 = new Hilo3(hilo2);
        hilo3.start();
    }
}

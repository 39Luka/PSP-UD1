package UD2_1;

class Hilo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hilo 1: Buenassss");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Actividad4 {
    public static void main(String[] args) {
        Hilo hilo = new Hilo();
        hilo.start();

            while(hilo.isAlive()) {
                try {
                    System.out.println("Main: Esta vivo :)");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("Main: Se murió :(");




        }
    }


package UD2_1;

class Hilo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Mensaje");
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

        while (true){
            if (hilo.isAlive()) {
                System.out.println("Esta vivo");
            }else {
                System.out.println("Se murió");
            }



        }
    }
}

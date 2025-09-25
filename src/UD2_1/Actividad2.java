package UD2_1;

class HiloA extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("Empieza el hiloA");
            System.out.println("A: Durmiendo...");
            sleep(10000);
            System.out.println("Termina el hiloA");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            if (Thread.currentThread().isInterrupted())
                System.out.println("A: Interrumpido");
        }
    }
}
class HiloB extends  Thread{
   Thread hiloA;

   HiloB(Thread hiloA){
       this.hiloA = hiloA;
   }

    @Override
    public void run() {
        try {
            System.out.println("Empieza el hiloB");
            System.out.println("B: Esperando...");
            sleep(3000);

            System.out.println("B: Interrumpiendo al HiloA...");
            hiloA.interrupt();

            System.out.println("Termina el hiloB");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Actividad2 {

    public static void main(String[] args) {

        HiloA hiloA = new HiloA();
        hiloA.start();

        HiloB hiloB = new HiloB(hiloA);
        hiloB.start();


    }
}

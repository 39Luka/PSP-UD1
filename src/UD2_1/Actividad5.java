package UD2_1;

import java.util.Scanner;

class HiloExtendido extends Thread{

    @Override
    public void run() {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Introduce un número");
            int num = sc.nextInt();
            int suma = 0;
            for (int i = 1; i < num ; i++) suma += i;

        }
    }
}
public class Actividad5 {
    public static void main(String[] args) {
        HiloExtendido he = new HiloExtendido();
        he.start();


        Thread hiloRun = new Thread(() ->{
            try {
                he.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Suma realizada con éxito");
        });

        hiloRun.start();

    }

}

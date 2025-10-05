package UD2_2;

import java.util.Random;

class Calculadora extends  Thread{

    int[] array = new int[10];
    Random rand = new Random();
   static int sumaGlobalConInterferencias = 0;

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0,100);
        }
        System.out.println(Thread.currentThread().getName() +" a sumado: " + calcularSuma(array));

    }

    private int calcularSuma(int[] xs){
        int total = 0;
        for (int i : xs){
            total+= i;

           sumaGlobalConInterferencias +=i;


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return total;
    }
}
public class Actividad6 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Calculadora(), "HiloA");
        Thread t2 = new Thread(new Calculadora(), "HiloB");
        Thread t3 = new Thread(new Calculadora(), "HiloC");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();

         System.out.println("Total global: " + Calculadora.sumaGlobalConInterferencias);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

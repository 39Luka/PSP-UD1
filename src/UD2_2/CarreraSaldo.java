package UD2_2;


public class CarreraSaldo {
    static int saldo = 0;
    public static void main(String[] args) throws InterruptedException {
        Runnable tarea = () -> {
            for (int i = 0; i < 100_000; i++) {
                saldo++;  // lectura + suma + escritura (no atómico)
                saldo--;  // idem
            }
        };
        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Saldo final: " + saldo);
    }
}

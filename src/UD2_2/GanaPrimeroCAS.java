package UD2_2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

public class GanaPrimeroCAS {
    private static final AtomicReference<String> winner = new AtomicReference<>(null);

    public static void main(String[] args) throws InterruptedException {
        Runnable competidor = () -> {
            String yo = Thread.currentThread().getName();
            // Simula trabajo aleatorio antes de "llegar a la meta"
            try { Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200)); }
            catch (InterruptedException ignored) {}

            // Intento de registrar ganador: SOLO si actualmente es null
            boolean fuiElPrimero = winner.compareAndSet(null, yo);
            if (fuiElPrimero) {
                System.out.println(yo + " se registra como GANADOR");
            } else {
                System.out.println(yo + " llegó, pero ya había ganador: " + winner.get());
            }
        };

        Thread t1 = new Thread(competidor, "A");
        Thread t2 = new Thread(competidor, "B");
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Ganador oficial: " + winner.get());
    }
}

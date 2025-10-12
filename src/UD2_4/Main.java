package UD2_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        double time = System.nanoTime();

        Map<String, Integer> stock = new HashMap<>();
        stock.put("SKU-001", 100);
        stock.put("SKU-002", 200);
        stock.put("SKU-003", 150);

        Erp erp = new Erp(stock);

        erp.crearPedido("P1", "SKU-001", 50);
        erp.crearPedido("P2", "SKU-002", 40);
        erp.crearPedido("P3", "SKU-003", 20);

        erp.crearPedido("P4", "SKU-001", 30); // se usa en t4

        Thread t1 = new Thread(() -> {
            erp.reservarStock("P1");
            erp.confirmarPedido("P1");
        });

        Thread t2 = new Thread(() -> {
            erp.reservarStock("P2");
            erp.confirmarPedido("P2");
        });

        Thread t3 = new Thread(() -> erp.reponerStock("SKU-003", 10));

        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            erp.reservarStock("P4");
            erp.confirmarPedido("P4");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Inventario: ");
        System.out.println(erp.getInventario());
        System.out.println("Pedidos: ");
        System.out.println(erp.getPedidos());

        System.out.println("Tiempo tardado : " + ((System.nanoTime() - time) / 1_000_000.0));
        System.out.println(erp.snapshotSku("SKU-001"));
    }
}

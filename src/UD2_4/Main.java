package UD2_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("SKU-001", 100);
        Erp erp = new Erp(stock);

        erp.crearPedido("P1", "SKU-001", 50);
        erp.crearPedido("P2", "SKU-001", 40);
        erp.crearPedido("P3", "SKU-001", 20);

        Thread t1 = new Thread(() ->
        {
            erp.reservarStock("P1");
            erp.confirmarPedido("P1");
        }
        );

        Thread t2 = new Thread(() -> {
            erp.reservarStock("P2");
            erp.confirmarPedido("P2");
        }
        );

        Thread t3 = new Thread(() -> erp.reponerStock("SKU-001", 10));


        Thread t4 = new Thread(()-> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            erp.reservarStock("P3");
            erp.confirmarPedido("P3");
        }
        );

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
    }
}

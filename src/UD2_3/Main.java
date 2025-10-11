package UD2_3;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Cajero c1 = new Cajero(tienda);
        Cajero c2 = new Cajero(tienda);
        Cajero c3 = new Cajero(tienda);
        Administrador administrador = new Administrador(tienda);

        // 🔹 Marca el inicio del tiempo
        long t0 = System.nanoTime();

        c1.start();
        c2.start();
        c3.start();
        administrador.start();

        try {
            c1.join();
            c2.join();
            c3.join();
            administrador.join();

            // 🔹 Calcula el tiempo total
            long tiempoTotal = System.nanoTime() - t0;

            System.out.println("Total Ventas: ");
            System.out.println(tienda.getTotalVentas());
            System.out.println("Total Transacciones: ");
            System.out.println(tienda.getTotalTransacciones());
            System.out.println("Últimas 3 ventas: ");
            System.out.println(tienda.getRegistroMontos());
            System.out.println("Tiempo total (ns): " + tiempoTotal);
            System.out.println("Tiempo total (ms): " + (tiempoTotal / 1_000_000.0));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

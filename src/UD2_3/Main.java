package UD2_3;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Cajero c1 = new Cajero(tienda);
        Cajero c2 = new Cajero(tienda);
        Cajero c3 = new Cajero(tienda);
        Administrador administrador = new Administrador(tienda);

        c1.start();
        c2.start();
        c3.start();
        administrador.start();


        try {
            c1.join();
            c2.join();
            c3.join();
            administrador.join();

            System.out.println(tienda.getTotalVentas());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

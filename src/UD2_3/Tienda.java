package UD2_3;

public class Tienda {
    private double totalVentas;

    public Tienda() {
        this.totalVentas = 0;
    }

    public void agregarVenta(int monto){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.totalVentas += monto;
    }
    public void aplicarDescuento(double descuento){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        totalVentas -= totalVentas*descuento/100;
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}

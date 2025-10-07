package UD2_3;

public class Tienda {
    int totalVentas;

    public Tienda() {
        this.totalVentas = 0;
    }

    public void agregarVenta(int monto){
        this.totalVentas += monto;
    }
}

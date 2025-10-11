package UD2_3;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private double totalVentas;
    private int totalTransacciones;
    private List<Integer> registroMontos;

    public Tienda() {
        this.totalVentas = 0;
        this.totalTransacciones = 0;
        this.registroMontos = new ArrayList<>();
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
        totalVentas -= totalVentas*descuento/100;
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}

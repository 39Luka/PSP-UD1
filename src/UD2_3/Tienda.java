package UD2_3;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private double totalVentas;
    private int totalTransacciones;
    private final List<Integer> registroMontos;

    private Object lockTotalVentas = new Object();
    private Object lockRegistrarVenta = new Object();
    private Object lockCantidadTransacciones = new Object();

    public Tienda() {
        this.totalVentas = 0;
        this.totalTransacciones = 0;
        this.registroMontos = new ArrayList<>();
    }

    private void agregarAlRegistro(int monto){
        registroMontos.add(monto);
        if(registroMontos.size() > 3){
            registroMontos.removeFirst();
        }
    }

    public void agregarVenta(int monto){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lockTotalVentas) {
            totalVentas += monto;
        }
        synchronized (lockRegistrarVenta){
            agregarAlRegistro(monto);
        }
        synchronized (lockCantidadTransacciones){
            totalTransacciones++;
        }
    }
    public void aplicarDescuento(double descuento){
        synchronized (lockTotalVentas){
            totalVentas -= totalVentas*descuento/100;}
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public List<Integer> getRegistroMontos() {
        return registroMontos;
    }
}

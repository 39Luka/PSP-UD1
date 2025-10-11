package UD2_4;

import java.util.HashMap;
import java.util.Map;

public class Erp {
    private Map<String,Integer> inventario;
    private Map<String,Pedido> pedidos;

    public Erp(Map<String, Integer> stockInicial) {
        this.inventario = stockInicial;
        this.pedidos = new HashMap<>();
    }

    public void crearPedido(String id,String sku, int unidades){
        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(unidades > 0) {
            Pedido nuevoPedido = new Pedido(id, unidades, sku);
            pedidos.put(id, nuevoPedido);
        }else{
            System.out.println("Las unidades tienen que ser superiores a 0");
        }
    }

    public void reponerStock(String sku, int unidades){
        inventario.put(sku, inventario.getOrDefault(sku,0) + unidades);
    }
    public void reservarStock(String id){
        try {
            Thread.sleep(77);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Pedido pedido = pedidos.get(id);
        String sku = pedido.getSku();
        int unidadesRequeridas = pedido.unidades;

        int unidadesDisponibles = inventario.get(sku);

        if (unidadesRequeridas <= unidadesDisponibles){
            pedido.setEstado(Estado.RESERVADO);
            pedidos.put(id, pedido);
        }else{
            System.out.println("No se puedo reservar el pedido " + id);
        }

    }

    public void confirmarPedido(String id){
        try {
            Thread.sleep(54);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Pedido pedido = pedidos.get(id);
        if(pedido.getEstado().equals(Estado.RESERVADO)){

            String sku = pedido.getSku();
            int unidadesRequeridas = pedido.unidades;

            inventario.put(sku, inventario.get(sku) - unidadesRequeridas);
            pedido.setEstado(Estado.CONFIRMADO);
            pedidos.put(id, pedido);

        }else{
            System.out.println("No se puede confirmar el pedido "+id+", ya que no esta reservado");
        }
    }

    public void cancelarPedido(String id){
        try {
            Thread.sleep(78);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Pedido pedido = pedidos.get(id);
        if(pedido.getEstado().equals(Estado.CONFIRMADO)) {
            String sku = pedido.getSku();
            int unidadesRequeridas = pedido.unidades;

            inventario.put(sku, inventario.get(sku) + unidadesRequeridas);
        }
        pedido.setEstado(Estado.CANCELADO);
        pedidos.remove(id);

    }

    public Map<String, Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Map<String, Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Map<String, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, Integer> inventario) {
        this.inventario = inventario;
    }
}

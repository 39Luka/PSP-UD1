package UD2_4;

import java.util.HashMap;
import java.util.Map;

public class Erp {
    private Map<String,Integer> inventario;
    private Map<String,Pedido> pedidos;

    final Object lockInventario = new Object();
    final Object lockPedidos = new Object();
    private final Map<String, Object> locksPorSku = new HashMap<>();

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
            synchronized (lockPedidos){
            pedidos.put(id, nuevoPedido);}
        }else{
            System.out.println("Las unidades tienen que ser superiores a 0");
        }
    }

    public  void reponerStock(String sku, int unidades){
        Object skuLock = lockDeSku(sku);
        synchronized (skuLock){
        inventario.put(sku, inventario.getOrDefault(sku,0) + unidades);
        }
    }
    public  void reservarStock(String id) {
        try {
            Thread.sleep(77);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Pedido pedido;
        synchronized (lockPedidos) {
            pedido = pedidos.get(id);
        }
        String sku = pedido.getSku();
        int unidadesRequeridas = pedido.getUnidades();

        int unidadesDisponibles;
        synchronized (lockInventario) {
            unidadesDisponibles = inventario.get(sku);
        }
        if (unidadesRequeridas <= unidadesDisponibles) {
            pedido.setEstado(Estado.RESERVADO);
            synchronized (lockPedidos){
            pedidos.put(id, pedido);}
        } else {
            System.out.println("No se puedo reservar el pedido " + id);
        }

    }

    public  void confirmarPedido(String id) {
        try {
            Thread.sleep(54);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Pedido pedido;
        synchronized (lockPedidos) {
            pedido = pedidos.get(id);
        }
        if (pedido.getEstado().equals(Estado.RESERVADO)) {

            String sku = pedido.getSku();
            int unidadesRequeridas = pedido.getUnidades();

            Object skuLock = lockDeSku(sku);
            synchronized (skuLock) {
                inventario.put(sku, inventario.get(sku) - unidadesRequeridas);
            }
            pedido.setEstado(Estado.CONFIRMADO);
            synchronized (lockPedidos){
            pedidos.put(id, pedido);}

        } else {
            System.out.println("No se puede confirmar el pedido " + id + ", ya que no esta reservado");
        }
    }

    public  void cancelarPedido(String id) {
        try {
            Thread.sleep(78);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Pedido pedido;
        synchronized (lockPedidos) {
            pedido = pedidos.get(id);
        }
        if (pedido.getEstado().equals(Estado.CONFIRMADO)) {
            String sku = pedido.getSku();
            int unidadesRequeridas = pedido.getUnidades();

            synchronized (lockInventario) {
                inventario.put(sku, inventario.get(sku) + unidadesRequeridas);
            }
        }
        pedido.setEstado(Estado.CANCELADO);
       synchronized (lockPedidos) {
           pedidos.remove(id);
       }

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
    private Object lockDeSku(String sku) {
        synchronized (lockInventario) {
            return locksPorSku.computeIfAbsent(sku, k -> new Object());
        }
    }

    public String snapshotSku(String sku) {
        int pedidosSku;
        synchronized (lockPedidos) {
            pedidosSku = (int) pedidos.values().stream().filter(p -> p.getSku().equals(sku)).count();
        }
        int stockSku;
        Object skuLock = lockDeSku(sku);
        synchronized (skuLock) {
            stockSku = inventario.getOrDefault(sku, 0);
        }
        return "SKU=" + sku + " | stock=" + stockSku + " | pedidos=" + pedidosSku;
    }
}

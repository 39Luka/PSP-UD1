package UD2_4;

import java.util.HashMap;
import java.util.Map;

public class Erp {
    Map<String,Integer> inventario;
    Map<String,Pedido> pedidos;

    public Erp(Map<String, Integer> stockInicial) {
        this.inventario = stockInicial;
        this.pedidos = new HashMap<>();
    }

    public void crearPedido(String id,String sku, int unidades){
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
}

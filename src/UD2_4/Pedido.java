package UD2_4;

public class Pedido {
    String id;
    String sku;
    int unidades;
    Estado estado;

    public Pedido(String id, int unidades, String sku) {
        this.id = id;
        this.unidades = unidades;
        this.sku = sku;
        this.estado = Estado.PENDIENTE;
    }

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public int getUnidades() {
        return unidades;
    }

    public Estado getEstado() {
        return estado;
    }
}

enum Estado{
    PENDIENTE,RESERVADO,CONFIRMADO,CANCELADO
}
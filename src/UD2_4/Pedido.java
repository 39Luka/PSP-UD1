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

    public void setId(String id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", unidades=" + unidades +
                ", estado=" + estado +
                '}';
    }
}

enum Estado{
    PENDIENTE,RESERVADO,CONFIRMADO,CANCELADO
}
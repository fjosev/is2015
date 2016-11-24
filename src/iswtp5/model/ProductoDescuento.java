package iswtp5.model;
public class ProductoDescuento {
    public ProductoDescuento(){}
    public ProductoDescuento(Producto producto, int cantidad){
        Producto = producto;
        Cantidad = cantidad; // 12) Se agrego Cantidad como parametro.
    }

    public Producto Producto;
    public int Cantidad;
}

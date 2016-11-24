package iswtp5.model;
import java.util.ArrayList;
public class Regla1 implements IRegla{
    private static final double porcentaje = 0.5d;
    @Override
    public double RealizarDescuento(Venta venta)
    {
        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        for (LineaVenta Detalle : venta.Detalle()) {
            if ("Panaderia".equals(Detalle.Producto.Rubro.Descripcion)) { // 3) Negación eliminada.
                boolean existe = false;
                for (ProductoDescuento productoDescuento : productos) {
                    if (productoDescuento.Producto.Codigo == Detalle.Producto.Codigo) {
                        existe = true;
                        productoDescuento.Cantidad += Detalle.Cantidad;
                        break;
                    }
                }
                if (!existe) { // 4) Agregada la negación.
                    productos.add(new ProductoDescuento(Detalle.Producto));
                }
            }
        }
        for(ProductoDescuento productoDescuento : productos)
        {
            if (productoDescuento.Cantidad == 2)
            {
                descuento += productoDescuento.Producto.Precio * porcentaje;
            }
            else if (productoDescuento.Cantidad == 3) // 5) Igualdad cambiada de >= 2 por == 3
            {
                descuento += productoDescuento.Producto.Precio * porcentaje * 2; // 6) Multiplica por 2 ya que se descuenta al 2 y al 3 producto.
            }
        }
        return descuento;
    }
}

    

    

    


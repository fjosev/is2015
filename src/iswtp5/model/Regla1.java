package iswtp5.model;
import java.util.ArrayList;
public class Regla1 implements IRegla{
    private static final double porcentaje = 0.10d;
    @Override
    public double RealizarDescuento(Venta venta)
    {
        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        for (LineaVenta Detalle : venta.Detalle()) {
            if ("Panaderia".equals(Detalle.Producto.Rubro.Descripcion)) {
                boolean existe = false;
                for (ProductoDescuento productoDescuento : productos) {
                    if (productoDescuento.Producto.Codigo == Detalle.Producto.Codigo) {
                        existe = true;
                        productoDescuento.Cantidad += Detalle.Cantidad;
                        break;
                    }
                }
                if (existe) {
                    productos.add(new ProductoDescuento(Detalle.Producto));
                }
            }
        }
        for(ProductoDescuento productoDescuento : productos)
        {
            if (productoDescuento.Cantidad == 2 || productoDescuento.Cantidad == 3)
            {
                descuento += productoDescuento.Producto.Precio * porcentaje;
            }
        }
        return descuento;
    }
}

    

    

    


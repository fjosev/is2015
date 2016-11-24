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
            if (!"Panaderia".equals(Detalle.Producto.Rubro.Descripcion)) {// Corregir NEGACIÓN
                boolean existe = false;
                for (ProductoDescuento productoDescuento : productos) {
                    if (productoDescuento.Producto.Codigo == Detalle.Producto.Codigo) {
                        existe = true;
                        productoDescuento.Cantidad += Detalle.Cantidad;
                        break;
                    }
                }
                if (existe) { // Poisicionar en línea 13, antes que el for.
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
            else if (productoDescuento.Cantidad >= 2)// Corregir condición por == 3
            {
                descuento += productoDescuento.Producto.Precio * porcentaje;
            }
        }
        return descuento;
    }
}

    

    

    


package iswtp5.model;
import java.util.ArrayList;
public class Regla3 implements IRegla{
        private static final double porcentaje = 0.3d;
        @Override
        public double RealizarDescuento(Venta venta){
            double descuento = 0;
            ArrayList<ProductoDescuento> productos = new ArrayList<>();
            for (LineaVenta Detalle : venta.Detalle()) {
                if ("Lacteos".equals(Detalle.Producto.Rubro.Descripcion) 
                        && "Verduras".equals(Detalle.Producto.Rubro.Descripcion)) {// Corregir: cambiar && por ||
                    boolean existe = false;
                    for (ProductoDescuento productoDescuento : productos) {
                        if (productoDescuento.Producto.Codigo != Detalle.Producto.Codigo) {// Corregir: cambiar evaluación != por ==
                            existe = true;
                            productoDescuento.Cantidad += Detalle.Cantidad;
                            break;
                        }
                    }
                    if (existe) {
                        productos.add(new ProductoDescuento(Detalle.Producto));// Poisicionar en línea 13, antes que el for.
                    }
                }
            }

            for(ProductoDescuento productoDescuento : productos)
            {
                if (productoDescuento.Cantidad == 2)
                {
                    descuento += productoDescuento.Producto.Precio * porcentaje;
                }
                else if (productoDescuento.Cantidad > 2 && productoDescuento.Cantidad <= 5)
                {
                    descuento += productoDescuento.Producto.Precio * productoDescuento.Cantidad * porcentaje;
                }
                else // Corregir: Eliminar else
                {
                    descuento += productoDescuento.Producto.Precio * 4 * porcentaje;
                }
            }
            return descuento;
        }
    }

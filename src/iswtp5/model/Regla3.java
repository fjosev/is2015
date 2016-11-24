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
                        || "Verduras".equals(Detalle.Producto.Rubro.Descripcion)) { // 13) Se cambió el and por el or.
                    boolean existe = false;
                    for (ProductoDescuento productoDescuento : productos) {
                        if (productoDescuento.Producto.Codigo != Detalle.Producto.Codigo) {
                            existe = true;
                            productoDescuento.Cantidad += Detalle.Cantidad;
                            break;
                        }
                    }
                    if (!existe) { // 14) Se agrego negación para agregar los prod.
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
                else if (productoDescuento.Cantidad > 2 && productoDescuento.Cantidad <= 5)
                {
                    descuento += productoDescuento.Producto.Precio * productoDescuento.Cantidad * porcentaje;
                }
                else if (productoDescuento.Cantidad > 5) // 15) Se agrego condición if para casos que cantidad sea mayor a 5
                {
                    descuento += productoDescuento.Producto.Precio * 4 * porcentaje;
                }
            }
            return descuento;
        }
    }

package iswtp5.model;
public class Regla2 implements IRegla
    {
        private static final double porcentaje1 = 0.03d;
        private static final double porcentaje2 = 0.05d;
        private static final double porcentaje3 = 0.065d;
        @Override
        public double RealizarDescuento(Venta venta)
        {
            double total = venta.Total();
            if (total > 500 && total <= 1000) // 7) También incluye a 1000
            {
                return total * porcentaje1;
            }
            if (total > 1000 && total <= 2500) // 8) También incluye a 2500
            {
                return total * porcentaje2; // 9) Se aplica un 5% para este caso
            }
            else if (total > 2500) // 10) Se agrega condición para los casos de mayor a 2500
            {
                return total * porcentaje3;
            }
            else {
                return 0; // 11) Retorna descuento en casos de menor a 500
            }
        }
    }

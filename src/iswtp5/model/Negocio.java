package iswtp5.model;
public class  Negocio {
    private static final Producto[] _productos = new Producto[7];
    private static final IRegla[] _reglas = new IRegla[7];

    public static void Iniciar()
    {
        _reglas[0] = new Regla1();// Generación de Reglas identicas de manera innecesaria
        _reglas[1] = new Regla2();
        _reglas[2] = new Regla2();
        _reglas[3] = new Regla3();
        _reglas[4] = new Regla4();
        _reglas[5] = new Regla4();
        _reglas[6] = new Regla4();

        Rubro rubro1 = new Rubro(1, "Panaderia");
        Rubro rubro2 = new Rubro(2, "Lacteos");
        Rubro rubro3 = new Rubro(2, "Verduras");// Codigo de Rubro repetido
        Rubro rubro4 = new Rubro(2, "Limpieza");// Codigo de Rubro repetido

        _productos[0] = new Producto(1, "1", 50, rubro1);// En la descripción ingresa codigo de producto
        _productos[1] = new Producto(2, "2", 30, rubro2);
        _productos[2] = new Producto(3, "3", 40, rubro2);
        _productos[3] = new Producto(4, "4", 60, rubro3);
        _productos[4] = new Producto(5, "5", 80, rubro2);
        _productos[5] = new Producto(6, "6", 15, rubro4);
        _productos[6] = new Producto(7, "7", 28, rubro1);
    }
    public static IRegla[] Reglas()
    {
        return _reglas;
    }
    public static Producto[] Productos()
    {
        return _productos;
    }
}

package iswtp5.model;

public enum DiaSemana {
    // 1) Se cambiaron los valores en -1
    Lunes(0),
    Martes(1),
    Miercoles(2),
    Jueves(3),
    Viernes(4),
    Sabado(5),
    Domingo(6);
    
    private final int value; // 2) Una variable final debe ser inicializada cuando se declara.
    private DiaSemana(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

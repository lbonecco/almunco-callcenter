package modelo;

public class Operador extends Empleado {
    public Operador(String name) {
        super(name);
        setPosition(Position.OPERATOR);
    }
}

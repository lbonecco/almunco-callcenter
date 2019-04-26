package modelo;

public class Director extends Empleado {
    public Director(String name) {
        super(name);
        setPosition(Position.DIRECTOR);
    }
}

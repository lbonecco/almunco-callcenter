package modelo;

public class Supervisor extends Empleado {

    public Supervisor(String name) {
        super(name);
        setPosition(Position.SUPERVISOR);
    }
}

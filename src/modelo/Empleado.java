package modelo;

public class Empleado implements Comparable<Empleado>{

    private String name;
    private Position position;

    public Empleado(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Empleado o) {
        return this.position.getValue().compareTo(o.getPosition().getValue());
    }

    @Override
    public String toString() {
        return name;
    }

    enum Position {

        OPERATOR(1),
        SUPERVISOR(2),
        DIRECTOR(3);

        private Integer value;

        public Integer getValue() {
            return value;
        }

        Position(Integer i) {
            this.value = i;
        }
    }
}


import modelo.Director;
import modelo.Empleado;
import modelo.Operador;
import modelo.Supervisor;
import service.Dispatcher;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        try {
            new Main().process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void process() throws InterruptedException {
        PriorityBlockingQueue<Empleado> empleados = new PriorityBlockingQueue<>();

        empleados.add(new Operador("Operator A"));
        empleados.add(new Operador("Operator B"));
        empleados.add(new Operador("Operator C"));

        empleados.add(new Supervisor("Supervisor A"));
        empleados.add(new Supervisor("Supervisor B"));

        empleados.add(new Director("Director A"));

        Dispatcher d = new Dispatcher(empleados);

        d.dispatchCall(10);

    }
}
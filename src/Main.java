import modelo.Director;
import modelo.Empleado;
import modelo.Operador;
import modelo.Supervisor;
import service.Dispatcher;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    public static void main() throws Exception {
        process();
    }

    public static void process() throws InterruptedException {
        PriorityBlockingQueue<Empleado> empleados = new PriorityBlockingQueue<>();

        empleados.add(new Operador("Operator A"));
        empleados.add(new Operador("Operator B"));
        empleados.add(new Operador("Operator C"));

        empleados.add(new Supervisor("Supervisor A"));
        empleados.add(new Supervisor("Supervisor B"));

        empleados.add(new Director("Director A"));

        Dispatcher d = new Dispatcher(empleados);

        for(int i = 0; i < 5; i++) {
            int callNumber = 1557234561 + i;
            d.dispatchCall(callNumber);
        }

    }
}

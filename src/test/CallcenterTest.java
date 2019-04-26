package test;

import modelo.Director;
import modelo.Empleado;
import modelo.Operador;
import modelo.Supervisor;
import service.Dispatcher;
import org.junit.Test;

import java.util.concurrent.PriorityBlockingQueue;

public class CallcenterTest {

    @Test
    public void testTenCalls() {
        PriorityBlockingQueue<Empleado> empleados = new PriorityBlockingQueue<>();

        empleados.add(new Operador("Operator A"));
        empleados.add(new Operador("Operator B"));
        empleados.add(new Operador("Operator C"));

        empleados.add(new Supervisor("Supervisor A"));
        empleados.add(new Supervisor("Supervisor B"));

        empleados.add(new Director("Director A"));

        Dispatcher d = new Dispatcher(empleados);

        for(int i = 0; i < 10; i++) {
            int callNumber = 1557234561 + i;
            d.dispatchCall(callNumber);
        }

    }

    @Test
    public void testTenCallsThreeEmployee() {
        PriorityBlockingQueue<Empleado> empleados = new PriorityBlockingQueue<>();

        empleados.add(new Operador("Operator A"));

        empleados.add(new Supervisor("Supervisor A"));

        empleados.add(new Director("Director A"));

        Dispatcher d = new Dispatcher(empleados);

        for(int i = 0; i < 10; i++) {
            int callNumber = 1557234561 + i;
            d.dispatchCall(callNumber);
        }

    }

}



























































































package service;

import modelo.Empleado;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher {
    private PriorityBlockingQueue<Empleado> empleados;
    private static final Integer MAX_THREADS = 10000;
    private ExecutorService pool ;


    public Dispatcher(PriorityBlockingQueue<Empleado> empleados) {
        this.empleados = empleados;
        this.pool = Executors.newFixedThreadPool(MAX_THREADS);
    }

    public void dispatchCall(Integer call) {

        Empleado empleado;
        try {
            empleado = empleados.take();
            System.out.println("Empleado " + empleado.getName() + " esta atendiendo llamada " + call);
            pool.execute(new CallEnding(empleados, empleado));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

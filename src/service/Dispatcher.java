package service;

import modelo.Empleado;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher {
    private PriorityBlockingQueue<Empleado> empleados;
    private static final Integer MAX_THREADS = 10000;


    public Dispatcher(PriorityBlockingQueue<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void dispatchCall(Integer call) {

        for(int i = 0; i < call; i++) {
            Empleado empleado;
            ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);

            try {
                empleado = empleados.take();
                System.out.println("Empleado " + empleado.getName() + " esta atendiendo llamada " + i);
                pool.execute(new CallEnding(empleados, empleado));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

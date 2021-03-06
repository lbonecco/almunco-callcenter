package service;

import modelo.Empleado;

import java.util.concurrent.PriorityBlockingQueue;

public class CallEnding implements Runnable {

    private Empleado e;
    private PriorityBlockingQueue<Empleado> empleados;
    private static final Integer CALL_DURATION = 10000;

    public CallEnding(PriorityBlockingQueue<Empleado> empleados, Empleado e){
        this.empleados = empleados;
        this.e = e;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(CALL_DURATION);
            empleados.add(e);
            System.out.println("El empleado " + e.getName() + " esta disponible nuevamente.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

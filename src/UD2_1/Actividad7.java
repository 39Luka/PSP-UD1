package UD2_1;

public class Actividad7 {
    public static void main(String[] args) {

        Thread hilo1 = new Thread(() ->{
            try {
                System.out.println("Hilo1: Comienzo");
                Thread.sleep(5000);
                System.out.println("Hilo1: Termino");
            } catch (InterruptedException e) {
                System.out.println("Hilo1: Interrumpido");

            }
        });
        Thread hilo2 = new Thread(() ->{
            try {
                hilo1.join();
                System.out.println("Hilo2: Mi turno");
                System.out.println("Hilo2: Termino");
            } catch (InterruptedException e) {
                System.out.println("Hilo2: Interrumpido");                 }
        });

        hilo1.start();
        hilo2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        System.out.println("Main: Interrumpo al hilo2");
//        hilo2.interrupt();

        //Si se interrumpe un hilo sigue a otro simplemente deja de seguirlo y no hace lo que tiene que hacer
        //Se pasa directamente al apartado de interrumpido y hace lo que pone en el catch
        // Es decir se interrumpe la ejecución y el join

       System.out.println("Main: Interrumpo al hilo1");
       hilo1.interrupt();
        //Cuando un hilo es interrumpido aquellos que lo siguen empiezan a ejecutar y el hilo interrumpido no termina lo que estaba haciendo
        //Básicamente el hilo siguiente continuo o si ha terminado o si se ha interrumpido su hilo predecesor
    }
}

package UD1_2;

import java.io.*;

public class Actividad4 {
    public static void main(String[] args) {
        //en windows cmd, en linux bash
        ProcessBuilder pb = new ProcessBuilder(new String[]{"bash"}); //Crea un proceso para ejecutar la consola

        Process process = null;
        try {
            process = pb.start();// Inicia el proceso

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream())); //Crea unos buffer de lectura y escritura
                 BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {

                bw.write("ls"); //Le manda como input a la consola el comando dir
                bw.newLine(); //Pone un salto de linea para decir que el comando se puede ejecutar (como si fuera un ENTER)
                bw.flush(); //Fuerza que lo anterior se envie


//                String line;
//                while ((line = br.readLine()) != null) { //Aquí lo que hace es que como se ha enviado ya lo que hay que escribir, entonces lee lo que devuelve como output(input aqui)
//                    System.out.println(line);//Y muestra linea a linea lo que se ha leido
//                }

                //A partir de aquí no se ejecuta nada porque se queda bloqueado esperando más salida

                bw.write("exit"); //Ahora escribe el comando para salir
                bw.newLine(); // ENTER
                bw.flush(); // Se fuerza que se envie

                //Correción: Se debe por una lado decir todo lo que se va ha escribir, cerrar la escritura
                // y luega empezar a leer el resultado si no se queda todo el rato esperando mas escritura
                bw.close();

                String line;
                while ((line = br.readLine()) != null) { //Aquí lo que hace es que como se ha enviado ya lo que hay que escribir, entonces lee lo que devuelve como output(input aqui)
                    System.out.println(line);//Y muestra linea a linea lo que se ha leido
                }
            }
            System.out.println(process.waitFor()); //Muestra codigo salida
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

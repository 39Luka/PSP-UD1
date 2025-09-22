package UD1_2;

import java.io.IOException;

public class Actividad6 {


        public static void main(String[] args) {
            try {
                ProcessBuilder pb = new ProcessBuilder("nslookup");

                pb.inheritIO();

                Process process = pb.start();

                int exitCode = process.waitFor();
                System.out.println("Código de salida: " + exitCode);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



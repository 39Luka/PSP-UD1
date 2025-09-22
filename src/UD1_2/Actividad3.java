package UD1_2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Actividad3 {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("bash", "-lc", "sleep 10");

        try {
            Process p = pb.start();

            boolean finished = p.waitFor(3, TimeUnit.SECONDS);

            if (!finished) {
                System.out.println("Timeout alcanzado.");
                p.destroy();

                finished = p.waitFor(1, TimeUnit.SECONDS);
                if (!finished) {
                    System.out.println(" Forzando destrucción...");
                    p.destroyForcibly();
                }
            }

            int exitCode = p.waitFor();
            System.out.println("Código de salida final: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

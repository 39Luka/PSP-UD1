package UD1_2;

import java.io.*;

public class Actividad5 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("sh");


        try {
           Process p = pb.start();

           try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()))){

               bw.write("ifconfig");
               bw.newLine();
               bw.flush();
               bw.close();

               int exitCode = p.waitFor();
               System.out.println(exitCode);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

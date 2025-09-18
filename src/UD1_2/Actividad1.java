package UD1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Actividad1 {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("ls","-l");
        try {

            Process p = pb.start();

            try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){

            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

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
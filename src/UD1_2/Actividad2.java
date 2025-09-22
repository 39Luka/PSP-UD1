package UD1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Actividad2 {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("bash", "-c", "comando_inexistente");
        try {
            Process p = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()))){
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

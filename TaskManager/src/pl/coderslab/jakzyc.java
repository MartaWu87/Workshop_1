package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class jakzyc {
    public static void main(String[] args) { //wywołanie zawartości pliku tasks.csv
        Path path = Paths.get("tasks.csv");
        try {
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}

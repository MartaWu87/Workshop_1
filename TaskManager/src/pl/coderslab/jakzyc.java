package pl.coderslab;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Scanner;

public class jakzyc {
    static final String FILE_NAME = "tasks.csv";
    static String[][] tasks;

    public static void main(String[] args) {
        tasks = dataFromFile(FILE_NAME);

        int i = 0; // pierwszy etap
        String[] list = {"add", "remove", "list", "exit"};
        System.out.println(ConsoleColors.BLUE + "Please select an option"); //nagłówek
        for (i = 0; i < list.length; i++) {
            System.out.println(ConsoleColors.RESET + list[i]);
        }
        choose();
    }

    public static String[][] dataFromFile(String fileName) { //wywołanie zawartości pliku tasks.csv
        Path path = Paths.get("tasks.csv");
        String[][] tab = null; //????????????????????????????
        try {
            List<String> strings = Files.readAllLines(path);

            String[][] dataFromFile = new String[strings.size()][strings.get(0).split(" , ").length]; //zamiana zawartości na listę

            for (int i = 0; i < strings.size(); i++) {  //wczytanie listy do tablicy dwuwymiarowej
                String[] split = strings.get(i).split(" , ");
                for (int j = 0; j < split.length; j++) {
                    dataFromFile[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab; // ?????????????????????????????????????
    }
    public static void choose() { // wybór opcji na pierwszym etapie
        Scanner scanner = new Scanner(System.in);
        String stepI = scanner.nextLine();
        //System.out.println(stepI);
          }



    }
}

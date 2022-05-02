package pl.coderslab;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class jakzyc {
    static final String FILE_NAME = "tasks.csv";
    static String[][] tasks;
    static String[][] split;
    static final String[] list = {"add", "remove", "list", "exit"};

    public static void main(String[] args) {
        tasks = dataFromFile(FILE_NAME);
        String stepI = null;
        int i = 0; // pierwszy etap
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
                    //System.out.println(Arrays.toString(split));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab; // ?????????????????????????????????????
    }

    public static void choose() { // wybór opcji na pierwszym etapie
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String stepI = scanner.next();
            //System.out.println(stepI);
            switch (stepI) {
                case "add":
                    adding();
                    break;
                case "remove":
                    scanner.nextLine();
                    break;
                case "list": //jak wrzucić listę unikając nullpoint exeption?????????????
                    //System.out.println(Arrays.toString(split));
                    break;
                case "exit":
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Please select a correct option");
            }
        }
    }
        public static void adding() { // dodawanie taska
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please add task description");
            String description = scanner.nextLine();
            System.out.println("Please add task due date");
            String dueDate = scanner.nextLine();
            System.out.println("Is your task important: true/false");
            String isImportant = scanner.nextLine();
            /*tasks = Arrays.copyOf(tasks, tasks.length + 1);       nie dodaje się -> jest nullpointer exception
            tasks[tasks.length - 1] = new String[3];
            tasks[tasks.length - 1][0] = description;
            tasks[tasks.length - 1][1] = dueDate;
            tasks[tasks.length - 1][2] = isImportant;
        */}
        }

package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class app {
    static final String FILE_NAME = "tasks.csv";
    static final String[] options = {"add", "remove", "list", "exit"};
    static String[][] fileWithTasks;

    public static void appOptions() {
        int i = 0;
        System.out.println();
        System.out.println(ConsoleColors.BLUE + "Please select an option");
        for (i = 0; i < options.length; i++) {
            System.out.println(ConsoleColors.RESET + options[i]);
        }
    }

    public static String[][] dataFromFile(String FILE_NAME) {
        Path path = Paths.get(FILE_NAME);
        fileWithTasks = null;
        try {
            List<String> strings = Files.readAllLines(path);
            fileWithTasks = new String[strings.size()][strings.get(0).split(" , ").length]; //zamiana zawartości na listę
            for (int i = 0; i < strings.size(); i++) {  //wczytanie listy do tablicy dwuwymiarowej
                String[] split = strings.get(i).split(" , ");
                for (int j = 0; j < split.length; j++) {
                    fileWithTasks[i][j] = split[j];
                    //System.out.println(Arrays.toString(split));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWithTasks;
    }

    public static void choose() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String stepI = scanner.next();
            //System.out.println(stepI);
            switch (stepI) {
                case "add":
                    adding();
                    break;
                case "remove":
                    removeRecord();
                    break;
                case "list":
                    showTable(fileWithTasks);
                    break;
                case "exit":
                    quit();
                    break;
                default:
                    System.out.println("Please select a correct option");
            }
            appOptions();
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
        fileWithTasks = Arrays.copyOf(fileWithTasks, fileWithTasks.length + 1);
        fileWithTasks[fileWithTasks.length - 1] = new String[3];
        fileWithTasks[fileWithTasks.length - 1][0] = description;
        fileWithTasks[fileWithTasks.length - 1][1] = dueDate;
        fileWithTasks[fileWithTasks.length - 1][2] = isImportant;
    }

    public static void showTable(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int removeRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove");
        int n = scanner.nextInt();
        if (n < 0 || n >= fileWithTasks.length) {
            System.out.println("number " + n + " out of scope");
            removeRecord();
        } else {
            fileWithTasks = ArrayUtils.remove(fileWithTasks, n);
            System.out.println("record " + n + " was successfully removed");
        }
       return n;
    }
    public static void quit() {
        Scanner scanner = new Scanner(System.in);
        //fileWithTasks = dataFromFile(FILE_NAME);
        Path path = Paths.get(FILE_NAME);
        String[] lines = new String[fileWithTasks.length];
        for (int i = 0; i < fileWithTasks.length; i++) {
            lines[i] = String.join(",", fileWithTasks[i]);
        }
        System.out.println(ConsoleColors.RED_BOLD + "bye, bye");
        System.exit(0);
    }
    public static void main(String[] args) {
        fileWithTasks = dataFromFile(FILE_NAME);
        appOptions();
        choose();
    }
}

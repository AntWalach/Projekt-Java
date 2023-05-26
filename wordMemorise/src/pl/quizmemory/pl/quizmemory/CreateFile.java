package pl.quizmemory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {

    public void createFile(String name) throws IOException {
        try {

            File file = new File(checkFileName(name));


            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }

    public void deleteFile(String fileName) throws IOException {
        try {
            //String fileName = nameFile();
            File f = new File(checkFileName(fileName));
            f.delete();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }

    public String checkFileName(String name) throws IOException {
        if (!name.contains(".txt")) {
            name += ".txt";
        }

        return name;
    }

    public String nameFile() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type file name: ");
        String fileName = scanner.next();
        fileName = checkFileName(fileName);


        return fileName;
    }


    @SuppressWarnings("resource")
    public void addContent() throws IOException {
        Scanner scanner = new Scanner(System.in);


        FileWriter write = new FileWriter(nameFile(), true);
        boolean add = true;


        while (add) {

            System.out.println("Adding content:");
            System.out.println("1.add");
            System.out.println("2.quit");

            int userChoice = scanner.nextInt();

            switch (userChoice) {

                case 1 -> {

                    String plWord = scanner.next();
                    String enWord = scanner.next();
                    write.write(plWord + "," + enWord + ",");
                    write.write(System.lineSeparator());
                }
                case 2 -> add = false;
                default -> System.out.println("The picked option doesn't exist.");

            }
        }
        write.close();

    }


    public void addContentToFile(String fileName, String plWord, String enWord) throws IOException {

        FileWriter write = new FileWriter(checkFileName(fileName), true);

        write.append("\n").append(plWord).append(",").append(enWord).append(",");

        write.close();

    }

}


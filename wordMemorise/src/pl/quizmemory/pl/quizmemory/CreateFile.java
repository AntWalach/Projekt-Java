package pl.quizmemory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile extends FilenameTemplate{

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

    public void addContentToFile(String fileName, String plWord, String enWord) throws IOException {
        FileWriter write = new FileWriter(checkFileName(fileName), true);
        write.append("\n").append(plWord).append(",").append(enWord).append(",");

        write.close();
    }
}


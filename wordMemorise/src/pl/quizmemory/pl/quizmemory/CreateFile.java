package pl.quizmemory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tworzenie nowych plików .txt
 */
public class CreateFile extends FilenameTemplate{
    /**
     * Funckja tworząca nowy plik na podstawie przekazanej nazwy
     * @param name - nazwa pliku .txt
     */
    public void createFile(String name) {
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

    /**
     * Funkcja usuwająca istniejący plik na podstawie przekazanej nazwy
     * @param fileName - nazwa pliku .txt
     */
    public void deleteFile(String fileName) {
        try {
            //String fileName = nameFile();
            File f = new File(checkFileName(fileName));
            f.delete();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }

    /**
     * Funkcja sprawdzająca czy nazwa pliku tekstowego ma rozszerzenie .txt
     * @param name - nazwa pliku
     * @return zwraca nazawę pliku z rozszerzeniem .txt
     * @throws IOException - wyjątek
     */
    public String checkFileName(String name) throws IOException {
        if (!name.contains(".txt")) {
            name += ".txt";
        }

        return name;
    }

    /**
     * Funkcja dodająca słowo wraz z tłumaczeniem do określonego pliku .txt
     * @param fileName - nazwa pliku
     * @param nativeWord - słowo w języku ojczystym
     * @param foreginWord - tłumaczenie słowa
     * @throws IOException - wyjątek
     */
    public void addContentToFile(String fileName, String nativeWord, String foreginWord) throws IOException {
        FileWriter write = new FileWriter(checkFileName(fileName), true);
        write.append("\n").append(nativeWord).append(",").append(foreginWord).append(",");

        write.close();
    }
}


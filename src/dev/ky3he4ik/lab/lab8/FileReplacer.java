package dev.ky3he4ik.lab.lab8;

import java.io.*;
import java.util.Scanner;

public class FileReplacer {
    public static void main(String[] args) {
        String filename;
        if (args.length > 0) {
            filename = args[0];
            System.out.println("Editing file " + args[0]);
        } else {
            filename = "testfile.txt";
            System.out.println("No program arguments provided. Using testfile.txt instead");
        }
        try {
            File file = new File(filename);
            if (!file.exists())
                file.createNewFile();
            if (file.isDirectory()) {
                System.err.println("It is a directory!");
                System.exit(0);
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            System.out.println("File content:\n");
            while ((st = br.readLine()) != null)
                System.out.println(st);
            System.out.println("\nNow write here some text. End by ctrl+D");
            br.close();

            Scanner scanner = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            while (scanner.hasNextLine())
                bw.write(scanner.nextLine());
            bw.close();
        } catch (IOException e) {
            System.err.println("An error occurred. " + e.getMessage());
            e.printStackTrace();
        }
    }
}

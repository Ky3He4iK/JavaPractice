package dev.ky3he4ik.lab.lab10;

import java.io.File;

public class ListDir {
    public static void main(String[] args) {
        String[] contents = new File("..").list();
        if (contents == null)
            System.out.println("Error: this is not an directory!");
        else {
            System.out.println("List of files and directories in the specified directory:");
            for (String content : contents)
                System.out.println(content);
        }
    }
}

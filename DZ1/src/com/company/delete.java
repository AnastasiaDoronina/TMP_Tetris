package com.company;

import java.io.File;

public class delete {
    public static void delfile(String filename)
    {

        File file = new File(filename);
        if(file.delete()){
            System.out.println("Файл " + filename + " удален из корневой папки проекта");
        }else System.out.println("Файл " + filename + " не был найден в корневой папке проекта");

    }

    static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }}

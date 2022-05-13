package com.company;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.*;
import static com.company.delete.*;
import static com.company.delete.delfile;
import static com.company.json.*;
import static com.company.txt.*;
import static com.company.xml.XmlRead;
import static com.company.xml.XmlWrite;
import static com.company.zip.unzip;
import static com.company.zip.zip2;

public class DZ {

    private static DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");


    public static List<Map<String, String>> getInfo() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        File [] roots = File.listRoots (); // Получить список разделов диска
        for (File file : roots) {
            Map<String, String> map = new HashMap<String, String>();

            long freeSpace=file.getFreeSpace();
            long totalSpace=file.getTotalSpace();
            long usableSpace=totalSpace-freeSpace;

            map.put("path", file.getPath());
            map.put ("freeSpace", freeSpace / 1024/1024/1024 + "G"); // Свободное пространство
            map.put ("usableSpace", usableSpace / 1024/1024/1024 + "G"); // Доступное пространство
            map.put ("totalSpace", totalSpace / 1024/1024/1024 + "G"); // общее пространство
            map.put ("проценты", DECIMALFORMAT.format (((double) usableSpace / (double) totalSpace) * 100) + "%"); // общее пространство

            list.add(map);
        }

        return list;
    }
    public static void printinfo() {
        File[] roots = File.listRoots();
        FileSystemView fsv = FileSystemView.getFileSystemView();

        for (File root : roots) {
            try {

                BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(root.toPath(), BasicFileAttributeView.class);

                BasicFileAttributes attributes = basicFileAttributeView.readAttributes();

                System.out.println("File Key: " + attributes.fileKey());
                System.out.println("Is Regular File: " + attributes.isRegularFile());
                System.out.println("Is Other: " + attributes.isOther());
                System.out.println("Is SymbolicLink: " + attributes.isSymbolicLink());
                System.out.println("Is Directory: " + attributes.isDirectory());

                System.out.println("Drive Name: " + root);
                System.out.println("Description: " + fsv.getSystemTypeDescription(root));
                System.out.println("Is Drive: " + fsv.isDrive(root));
                System.out.println("Is File System: " + fsv.isFileSystem(root));
                System.out.println("Is File System Root: " + fsv.isFileSystemRoot(root));
                System.out.println("Is Floppy Drive: " + fsv.isFloppyDrive(root));
                System.out.println("Is Hidden File: " + fsv.isHiddenFile(root));
                System.out.println("Is Traversable: " + fsv.isTraversable(root));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) throws Exception {

        System.out.println(getInfo());
        printinfo();
        System.out.println("\n");

        System.out.println("Введите строку для ввода в txt-файл:");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        in_txt_file(string);
        System.out.println("Информация из созданного txt-файла:");
        out_txt("notes3.txt");
        delfile("notes3.txt");
        System.out.println("\n");

        String filen= "kek.json";
        writeJsonSimpleDemo(filen);
        user User1=new user("username",41231);
        json.truejs_wr(User1);
        json.truejs_rr("sup.json");
        js_write(User1);
        js_read_del();
        delfile("temp.json");
        System.out.println("\n");

        XmlWrite("xmlDogFile.xml");
        XmlRead("xmlDogFile.xml");
        delfile("xmlDogFile.xml");
        System.out.println("\n");

        System.out.println("Введите название txt-файла, который подлежит архивации:");
        Scanner in2 = new Scanner(System.in);
        String string2 = in2.nextLine();
        zip2(string2);
        unzip();

        Path txtfile = Paths.get("src\\unzipTest\\tozip.txt");
        System.out.println("Информация из Разархивированного txt-файла:");
        out_txt(txtfile.toString());
        System.out.println("\n");
        delfile("compressed.zip");
        Path pathToBeDeleted = Paths.get("src\\unzipTest");
        deleteDirectory(pathToBeDeleted.toFile());

    }

}
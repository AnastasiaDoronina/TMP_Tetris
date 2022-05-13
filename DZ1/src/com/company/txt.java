package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.company.delete.delfile;

public class txt {
    public static void in_txt_file(String text) {

        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            // запись всей строки
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static void out_txt(String filename) {

        try(FileReader reader = new FileReader(filename))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
}

package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class json {
    public static void writeJsonSimpleDemo(String filename) throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", "Stackabuser");
        sampleObject.put("id", 1234);

        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
    }
    public static void js_write(user USER) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.json");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(USER);
        oos.flush();
        oos.close();
    }
    public static void js_read_del() throws Exception {
        FileInputStream fis = new FileInputStream("temp.json");
        ObjectInputStream oin = new ObjectInputStream(fis);
        user ts = (user) oin.readObject();
        System.out.println("Информация из JSON-файла:");
        System.out.println("name="+ts.name+" id="+ts.id);
        oin.close();
    }
    public static void truejs_wr(user user) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(user);

        try(FileWriter writer = new FileWriter("sup.json", false))
        {
            writer.write(json);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static void truejs_rr(String fileName) {
        List<Character> E =  new ArrayList<Character>();
        try(FileReader reader = new FileReader(fileName))
        {int c;
            while((c=reader.read())!=-1){E.add((char)c);}
        }
        catch(IOException ex){System.out.println(ex.getMessage());}

        StringBuilder builder = new StringBuilder(E.size());
        for(Character ch: E)
        {builder.append(ch);}
        String thestr = builder.toString();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        user Bigus = gson.fromJson(thestr,user.class);
        System.out.println("id="+Bigus.id+" name="+Bigus.name);
    }



}

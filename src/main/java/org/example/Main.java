package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,DirectoryCreator> creators= new HashMap<>();
        creators.put("txt",new DirectoryCreator("testV3\\txt"));
        File here =new File("testV3");
        File[] list= here.listFiles();
        for (File f : list){

            if (f.getName().split("\\.").length<2)continue;
            if(f.getName().split("\\.")[f.getName().split("\\.").length-1].equals("txt")){
                f.renameTo(new File(creators.get("txt").file.getPath().toString()+"\\"+f.getName()));
            }
        }

    }
}
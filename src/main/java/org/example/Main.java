package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String presentFileName="test";
        if(args.length>0){
            presentFileName=args[0];
        }
        HashMap<String,DirectoryCreator> creators= new HashMap<>();

        File here =new File(presentFileName);
        if(!here.exists()){
            throw new RuntimeException("No such file : "+presentFileName);
        }
        File[] list= here.listFiles();
        for (File f : list){

            if (f.getName().split("\\.").length<2)continue;
            String type=f.getName().split("\\.")[f.getName().split("\\.").length-1];
            if(!creators.keySet().contains(type )){
                creators.put(type,new DirectoryCreator(presentFileName+"\\"+type));

            }
            creators.get(type).moveFile(f);
        }

    }
}
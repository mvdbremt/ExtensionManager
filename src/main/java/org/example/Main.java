package org.example;

import java.io.File;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String presentFileName="test"; //Default directory name for directory to reorganise
        if(args.length>0){
            //Get name of directory to organise from arguments if arguments not empty
            presentFileName=args[0];
        }

        //Hashmap containing DirectoryCreator for every extension in directory
        HashMap<String,DirectoryCreator> creators= new HashMap<>();

        //Finds directory to organise
        File here =new File(presentFileName);

        //Manage exception
        if(!here.exists()){
            throw new RuntimeException("No such file : "+presentFileName);
        }
        //Find list of files in directory
        File[] list= here.listFiles();

        //Main organisation loop
        assert list != null;
        for (File f : list){

            if (f.getName().split("\\.").length<2)continue;

            String type=f.getName().split("\\.")[f.getName().split("\\.").length-1];

            if(!creators.containsKey(type )){
                creators.put(type,new DirectoryCreator(presentFileName+"\\"+type));
            }

            creators.get(type).moveFile(f);
        }

    }
}
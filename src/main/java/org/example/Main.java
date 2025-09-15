package org.example;

import java.io.File;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String presentFileName="."; //Default directory name for directory to reorganise
        if(args.length>0){
            //Get name of directory to organise from arguments if arguments not empty
            presentFileName=args[0];
        }

        //Hashmap containing DirectoryManager for every extension in directory
        HashMap<String, DirectoryManager> creators= new HashMap<>();

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
            //seperate name from extension and verify if it has extension
            if (f.getName().split("\\.").length<2)continue;
            //seperate name from extension and takes extension
            String type=f.getName().split("\\.")[f.getName().split("\\.").length-1];

            if(!creators.containsKey(type )){
                //add unique new DirectoryManager for each type
                creators.put(type,new DirectoryManager(presentFileName+File.separator+type));
            }
            //use DirectoryManager to move file to right place
            creators.get(type).moveFile(f);
        }

    }
}
package org.example;

import java.io.*;
public class DirectoryCreator {
    File file;
    public DirectoryCreator(String name){
        file = new File(name);
        file.mkdir();

    }

    public void moveFile(File f){
        f.renameTo(new File(file.getPath().toString()+"\\"+f.getName()));
    }
}

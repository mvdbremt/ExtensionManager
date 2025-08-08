package org.example;

import java.io.*;
public class DirectoryCreator {
    File file;

    /**
     * Creates a new directory
     * @param name : Name for new directory
     *
     */
    public DirectoryCreator(String name){

        file = new File(name);
        file.mkdir();

    }

    /**
     * Moves a file to the directory contained in DirectoryCreator
     * @param f : File that must be moves in directory
     */
    public void moveFile(File f){
        f.renameTo(new File(file.getPath() +"\\"+f.getName()));
    }
}

package org.example;

import java.io.*;

/**
 * Class that manages each directory
 */
public class DirectoryManager {
    File file;

    /**
     * Creates a new directory
     * @param name : Name for new directory
     *
     */
    public DirectoryManager(String name){

        file = new File(name);
        file.mkdir();

    }

    /**
     * Moves a file to the directory contained in DirectoryManager
     * @param f : File that must be moves in directory
     */
    public void moveFile(File f){
        f.renameTo(new File(file.getPath() + File.separator+f.getName()));
    }
}

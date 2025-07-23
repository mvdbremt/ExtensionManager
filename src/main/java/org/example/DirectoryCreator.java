package org.example;

import java.io.*;
public class DirectoryCreator {
    File file;
    public DirectoryCreator(String name){
        file = new File(name);
        file.mkdir();

    }
}

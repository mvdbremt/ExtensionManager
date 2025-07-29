package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryCreatorTest {
    @Test
    void doesCreatorCreateFile(){
        DirectoryCreator dc= new DirectoryCreator("testV2");
        File f= new File("testV2");
        assertTrue(f.exists());
        f.delete();
    }

    @Test
    void doesmoveFile() {
        DirectoryCreator dc= new DirectoryCreator("testV2");
        File f= new File("testV2");
        File f2= new File("movetest.txt");
        try {
            f2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dc.moveFile(f2);
        File[] list= f.listFiles();
        f2=new File("testV2\\movetest.txt");
        assertTrue(Arrays.asList(list).contains(f2));
        f2.delete();
        dc.file.delete();
    }
}
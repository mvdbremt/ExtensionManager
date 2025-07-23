package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryCreatorTest {
    @Test
    void doesCreatorCreateFile(){
        DirectoryCreator dc= new DirectoryCreator("testV2");
        File f= new File("testV2");
        assertTrue(f.exists());
        f.delete();
    }
}
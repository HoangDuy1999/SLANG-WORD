/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangword;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Duy
 */
public class BackupDatabase {

    public void fBackupDataBase() throws FileNotFoundException, IOException {
        // create object of Path
        Path path
                = Paths.get("slangbk.txt");

        // deleteIfExists File
        try {

            Files.deleteIfExists(path);
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        var source = new RandomAccessFile("slang.txt", "r");
        var dest = new RandomAccessFile("slangbk.txt", "rw");

        try (var sfc = source.getChannel();
                var dfc = dest.getChannel()) {

            dfc.transferFrom(sfc, 0, sfc.size());
        }
    }

    public void restoreDatabase() throws FileNotFoundException, IOException {
        // create object of Path
        Path path
                = Paths.get("slang.txt");

        // deleteIfExists File
        try {

            Files.deleteIfExists(path);
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        var source = new RandomAccessFile("slangbk.txt", "r");
        var dest = new RandomAccessFile("slang.txt", "rw");
        try (var sfc = source.getChannel();
                var dfc = dest.getChannel()) {

            dfc.transferFrom(sfc, 0, sfc.size());
        }
    }

    public void resetDatabase() throws FileNotFoundException, IOException {
        // create object of Path
        Path path
                = Paths.get("slang.txt");

        // deleteIfExists File
        try {

            Files.deleteIfExists(path);
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        var source = new RandomAccessFile("slang_root.txt", "r");
        var dest = new RandomAccessFile("slang.txt", "rw");

        try (var sfc = source.getChannel();
                var dfc = dest.getChannel()) {

            dfc.transferFrom(sfc, 0, sfc.size());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangword;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Duy
 */
public class BackupDatabase {

    public void fBackupDataBase() throws FileNotFoundException, IOException {
        var source = new RandomAccessFile("slang.txt", "r");
        var dest = new RandomAccessFile("slangbk.txt", "rw");

        try (var sfc = source.getChannel();
                var dfc = dest.getChannel()) {

            dfc.transferFrom(sfc, 0, sfc.size());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangword;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Duy
 */
public class ReadFile {

    public void ReadFileTXTIntoStructureData(Hashtable<String, String> htbKey, Hashtable<String, String> htbMean) {
        try {
            File myObj = new File("slang.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String str = myReader.nextLine();
                String[] aStr = str.split("`");
                if (aStr.length > 1) {
                    //htbkey : key, min
                    //htbmean: min, key(tổng hợp tất cả các key có nghĩa này)
                    htbKey.put(String.valueOf(aStr[0]).trim(), String.valueOf(aStr[1]).trim());
                    //lấy ra tất cả các nghĩa
                    String means = aStr[1].trim();
                    String[] aMean = means.split("\\|");
//                    for (int i = 0; i < aMean.length; i++) {
//                        System.out.println(aMean[i] + i);
//                    }
                    for (String aMean1 : aMean) {
                        // chưa có nghĩa này trong htb mean
                        if (htbMean.get(aMean1.trim().toLowerCase()) == null) {
                            htbMean.put(aMean1.trim().toLowerCase(), String.valueOf(aStr[0]).trim());
                        } else {
                            String temp = htbMean.get(aMean1.trim().toLowerCase());
                            temp = temp + "`" + String.valueOf(aStr[0]).trim();
                            htbMean.put(aMean1.trim().toLowerCase(), temp);
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangword;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Duy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BackupDatabase bk = new BackupDatabase();
        bk.fBackupDataBase();
        Hashtable<String, String> htbKey = new Hashtable<String, String>();
        Hashtable<String, String> htbMean = new Hashtable<String, String>();
        ReadFile r = new ReadFile();
        r.ReadFileTXTIntoStructureData(htbKey, htbMean);
        // getting keySet() into Set
        Set<String> setOfCountries = htbMean.keySet();
        int i = 0;
        // for-each loop
        for (String key : setOfCountries) {
            if(i > 100){
                break;
            }
            i++;
//            System.out.println("mean : " + key
//                    + "\t key : " + htbMean.get(key));
        }
        System.out.println(htbMean.get("Angry"));
        int functionID = 0;
        do {
            chiTietChucNang();
            Scanner scanner = new Scanner(System.in);
            functionID = scanner.nextInt();
            System.out.println(functionID);
            switch (functionID) {
                case 1 -> {
                    TimKiemTheoKhoa(htbKey);
                }
                case 2 -> {
                    TimKiemTheoNghia(htbKey);
                }
                case 3 -> {
                    LichSuTimKiem(htbKey);
                }
                case 4 -> {
                    ThemMotTuVung(htbKey);
                }
                case 5 -> {
                    SuaMotMotTuVung(htbKey);
                }
                case 6 -> {
                    XoaMotTuVung(htbKey);
                }
                case 7 -> {
                    KhoiPhucCSDL(htbKey);
                }
                case 8 -> {
                    HienThiNgauNhien(htbKey);
                }
                case 9 -> {
                    KyHieuTimNghia(htbKey);
                }
                case 10 -> {
                    NghiaTimKyHieu(htbKey);
                }
                case 0 -> {

                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("CHƯƠNG TRÌNH KẾT THÚC");
                    System.out.println("=============================THÔNG BÁO=============================\n");
                }
                default -> {
                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                    System.out.println("\n=============================THÔNG BÁO=============================");
                }
            }
        } while (functionID != 0);
    }

    private static void chiTietChucNang() {
        System.out.println("\n*** SLANG WORD  ***\n");
        System.out.println("Danh Sách Chức năng:");
        System.out.println("0. Thoát chương trình.");
        System.out.println("1. Chức năng tìm kiếm theo slang word.");
        System.out.println("2. Chức năng tìm kiếm theo nghĩa(định nghĩa).");
        System.out.println("3. Chức năng hiển thị lịch sử tìm kiếm.");
        System.out.println("4. Chức năng thêm một slang words.");
        System.out.println("5. Chức năng sửa một slang words.");
        System.out.println("6. Chức năng xóa một slang words.");
        System.out.println("7. Khôi phục danh sach slang words về nguyên bản.");
        System.out.println("8. Chức năng hiện thi ngẫu nhiên thông tin một slang word ");
        System.out.println("9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.");
        System.out.println("10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.");
        System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
    }

    private static void TimKiemTheoKhoa(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void TimKiemTheoNghia(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void LichSuTimKiem(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void ThemMotTuVung(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void SuaMotMotTuVung(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void XoaMotTuVung(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void KhoiPhucCSDL(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void HienThiNgauNhien(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void KyHieuTimNghia(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

    private static void NghiaTimKyHieu(Hashtable<String, String> htbKey) {
        System.out.println("ok");
    }

}

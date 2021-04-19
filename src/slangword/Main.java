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
        Hashtable<String, String> HtbHistory = new Hashtable<String, String>();
        ReadFile r = new ReadFile();
        r.ReadFileTXTIntoStructureData(htbKey, htbMean);
        int functionID = 0;
        do {
            chiTietChucNang();
            Scanner scanner = new Scanner(System.in);
            functionID = scanner.nextInt();
            switch (functionID) {
                case 1 -> {
                    TimKiemTheoKhoa(htbKey, HtbHistory);
                }
                case 2 -> {
                    TimKiemTheoNghia(htbMean, HtbHistory);
                }
                case 3 -> {
                    LichSuTimKiem(HtbHistory);
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

    private static void TimKiemTheoKhoa(Hashtable<String, String> htbKey, Hashtable<String, String> HtbHistory) {
        int functionID = 0;
        do {
            System.out.println("\n^^^ CHỨC NĂNG TÌM KIẾM THEO KHÓA ^^^\n");
            System.out.println("0. Thoát chức năng.");
            System.out.println("1. Tìm kiếm theo khóa.");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
            Scanner scanner = new Scanner(System.in);
            functionID = scanner.nextInt();
            switch (functionID) {
                case 0 -> {

                }
                case 1 -> {
                    System.out.println("Mời bạn nhập khóa(slang):");
                    String key = scanner.next();
                    if (htbKey.get(key) != null) {
                        System.out.println("Khóa `" + key + "` có nghĩa là `" + htbKey.get(key) + "`.");
                        HtbHistory.put(key, htbKey.get(key));
                    } else {
                        System.out.println("Hệ thông không tìm thấy nghĩa cho khóa là `" + key + "`.");
                    }
                }
                default -> {
                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                    System.out.println("\n=============================THÔNG BÁO=============================");
                }
            }
        } while (functionID != 0);
    }

    private static void TimKiemTheoNghia(Hashtable<String, String> htbMean, Hashtable<String, String> HtbHistory) {
        int functionID = 0;
        do {
            System.out.println("\n^^^ CHỨC NĂNG TÌM KIẾM THEO NGHĨA ^^^\n");
            System.out.println("0. Thoát chức năng.");
            System.out.println("1. Tìm kiếm theo nghĩa.");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
            Scanner scanner = new Scanner(System.in);
            functionID = scanner.nextInt();
            switch (functionID) {
                case 0 -> {

                }
                case 1 -> {
                    System.out.println("Mời bạn nhập nghĩa:");
                    String mean = scanner.next();
                    mean = mean.trim().toLowerCase();
                    if (htbMean.get(mean) != null) {
                        String str = "Nghĩa của từ `" + mean + "` có các khóa là `";
                        String means = htbMean.get(mean);
                        String[] aMean = means.trim().split("`");
                        for (int i = 0; i < aMean.length - 1; i++) {
                            str = str + aMean[i] + ", ";
                        }
                        str = str + aMean[aMean.length - 1] + "`.";
                        HtbHistory.put(mean, str);
                        System.out.println(str);
                    } else {
                        System.out.println("Hệ thông không tìm thấy khóa cho nghĩa là `" + mean + "`");
                    }
                }
                default -> {
                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                    System.out.println("\n=============================THÔNG BÁO=============================");
                }
            }
        } while (functionID != 0);
    }

    private static void LichSuTimKiem(Hashtable<String, String> HtbHistory) {
        System.out.println("\n***Lịch Sử Tìm Kiếm *** \n");
        Set<String> setOfCountries = HtbHistory.keySet();

        // for-each loop
        for (String key : setOfCountries) {
            System.out.println(key + " : " + HtbHistory.get(key));
        }
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

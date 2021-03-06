/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangword;

import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        //htbKey là lưu key: definition
        Hashtable<String, String> htbKey = new Hashtable<String, String>();
        //htbMean là lưu nghĩa: tất cả key có nghĩa đó
        Hashtable<String, String> htbMean = new Hashtable<String, String>();
        // TỐN BỘ NHỚ NHƯNG TRUY XUẤT DỮ LIỆU 0.01 s
        Hashtable<String, String> HtbHistory = new Hashtable<String, String>();
        ReadFile r = new ReadFile();
        // ĐỌC DỮ LIỆU VÔ CẤP TRÚC DỮ LIỆU
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
                    ThemMotTuVung(htbKey, htbMean);
                }
                case 5 -> {
                    SuaMotMotTuVung(htbKey, htbMean);
                }
                case 6 -> {
                    XoaMotTuVung(htbKey, htbMean);
                }
                case 7 -> {
                    KhoiPhucCSDL(htbKey, htbMean);
                }
                case 8 -> {
                    HienThiNgauNhien(htbKey);
                }
                case 9 -> {
                    KyHieuTimNghia(htbKey);
                }
                case 10 -> {
                    NghiaTimKyHieu(htbKey, htbMean);
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
        System.out.println("7. Khôi phục danh sách slang words về nguyên bản.");
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
                        HtbHistory.put(key, "Không tìm thấy nghĩa");
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
                    scanner.nextLine();
                    String mean = scanner.nextLine();
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
                        HtbHistory.put(mean, "Không tìm thấy khóa");
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

    private static void ThemMotTuVung(Hashtable<String, String> htbKey, Hashtable<String, String> htbMean) throws IOException {
        int functionID = 0;
        do {
            System.out.println("\n^^^ CHỨC NĂNG THÊM MỘT TỪ VỰNG(SLANG WORD) ^^^\n");
            System.out.println("0. Thoát chức năng.");
            System.out.println("1. Thêm từ vựng.");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
            Scanner scanner = new Scanner(System.in);
            functionID = scanner.nextInt();
            switch (functionID) {
                case 0 -> {
                }
                case 1 -> {
                    System.out.println("Mời bạn nhập khóa(key):");
                    String key = scanner.next();
                    System.out.println("Mời bạn nhập nghĩa(mean):");
                    System.out.println("Ghi Chú: Nếu có nhiều nghĩa thì giữa các nghĩa nối nhau bằng dấu `|`.");
                    scanner.nextLine();
                    String mean = scanner.nextLine();
                    mean = mean.trim().toLowerCase();
                    if (htbKey.get(key.trim()) == null) {
                        try {
                            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("slang.txt", true)));
                            out.println(key.trim() + "`" + mean.trim());
                            out.flush();
                            out.close();
                            htbKey.put(key.trim(), mean.trim());
                            String[] aMean = mean.trim().split("\\|");
                            for (String aMean1 : aMean) {
                                // chưa có nghĩa này trong htb mean
                                if (htbMean.get(aMean1.trim().toLowerCase()) == null) {
                                    htbMean.put(aMean1.trim().toLowerCase(), key);
                                } else {
                                    String temp = htbMean.get(aMean1.trim().toLowerCase());
                                    temp = temp + "`" + key;
                                    htbMean.put(aMean1.trim().toLowerCase(), temp);
                                }
                            }
                            System.out.println("\n(^.^)Thêm từ vựng thành công(^.^).\n");
                        } catch (IOException e) {
                            System.out.println("\n(`.`)Thêm từ vựng thất bại(`.`).\n");
                            println(e);
                        }
                    } else {
                        int fId = 0;
                        do {
                            System.out.println("\n#### CƠ SỞ DỮ LIỆU ĐÃ TỒN TẠI SLANG WORD NÀY ####\n");
                            System.out.println(key + " có nghĩa là ` " + htbKey.get(key.trim()) + " `.");
                            System.out.println("Bạn có các sự lựa chọn:");
                            System.out.println("0. Không thêm mới và quay lại.");
                            System.out.println("1. Ghi đè dữ liệu(overwrite).");
                            System.out.println("2.Thêm nghĩa mới cho khóa(key).");
                            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
                            fId = scanner.nextInt();
                            switch (fId) {
                                case 0 -> {
                                }
                                case 1 -> {
                                    String tMean = htbKey.get(key.trim());
                                    String[] aOldMean = tMean.split("\\|");
                                    String[] aNewMean = mean.trim().split("\\|");
                                    GhiDeDuLieuMotDong(key.trim() + "`" + htbKey.get(key.trim()), key.trim() + "`" + mean);
                                    // cập nhật cơ sở dữ liêu thành công
                                    htbKey.put(key.trim(), mean.trim());
                                    // xóa các nghĩa cũ có key này
                                    for (String oldMean : aOldMean) {
                                        if (htbMean.get(oldMean.trim()) != null) {
                                            String temp = htbMean.get(oldMean.trim());
                                            temp = temp.replace(key.trim(), "");
                                            temp = temp.replace("``", "`");
                                            if (temp.length() < 2) {
                                                temp = "";
                                                htbMean.remove(oldMean.trim());
                                            } else {
                                                htbMean.put(oldMean.trim(), temp);
                                            }
                                        }
                                    }
                                    // cập nhật nghĩa mới
                                    for (String newMean : aNewMean) {
                                        if (htbMean.get(newMean.trim()) != null) {
                                            String temp = htbMean.get(newMean.trim());
                                            temp = temp + "`" + key.trim();
                                            htbMean.put(newMean.trim(), temp);
                                        } else {
                                            htbMean.put(newMean.trim(), key.trim());
                                        }
                                    }
                                    System.out.println("\n(^.^)Thêm từ vựng thành công(^.^).\n");
                                }
                                case 2 -> {
                                    String tMean = htbKey.get(key.trim());
                                    System.out.println("Nghĩa cũ "+ tMean);
                                    String[] aOldMean = tMean.split("\\|");
                                    String[] aNewMean = mean.trim().split("\\|");
                                    ArrayList<String> trueNewMean = new ArrayList<>();
                                    boolean check = false;
                                    // lây ra các nghĩa mới còn trùng thì thôi
                                    for (int i = 0; i < aNewMean.length; i++) {
                                        check = false;
                                        for (int j = 0; j < aOldMean.length; j++) {
                                            if (aNewMean[i].trim().equals(aOldMean[j].trim())) {
                                                check = true;
                                            }
                                        }
                                        if (check == false) {
                                            trueNewMean.add(aNewMean[i]);
                                        }
                                    }
                                    String str = "";
                                    if (trueNewMean.size() > 0) {
                                        for (int i = 0; i < trueNewMean.size() - 1; i++) {
                                            str = str + trueNewMean.get(i) + "|";
                                        }
                                        str = str + trueNewMean.get(trueNewMean.size() - 1);
                                        if (str != "") {
                                            GhiDeDuLieuMotDong(key.trim() + "`" + htbKey.get(key.trim()), key.trim() + "`" + htbKey.get(key.trim()) + "|" + str);
                                        }
                                        for (int i = 0; i < trueNewMean.size(); i++) {
                                            if (htbMean.get(trueNewMean.get(i).trim()) != null) {
                                                String temp = htbMean.get(trueNewMean.get(i).trim());
                                                temp = temp + "`" + key.trim();
                                                htbMean.put(htbMean.get(trueNewMean.get(i).trim()), temp);
                                            } else {
                                                htbMean.put(trueNewMean.get(i).trim(), key.trim());
                                            }
                                        }
                                    }
                                    htbKey.put(key.trim(), htbKey.get(key.trim()) + "|" + str);
                                    System.out.println("\n(^.^)Thêm từ vựng thành công(^.^).\n");
                                }
                                default -> {
                                    System.out.println("\n=============================THÔNG BÁO=============================");
                                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                                    System.out.println("\n=============================THÔNG BÁO=============================");
                                }
                            }
                        } while (fId > 2 && fId < 0);
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

    private static void GhiDeDuLieuMotDong(String oldLine, String newLine) throws FileNotFoundException, IOException {
        String filePath = "slang.txt";
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.replace(oldLine, newLine);
        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }

    private static void SuaMotMotTuVung(Hashtable<String, String> htbKey, Hashtable<String, String> htbMean) throws IOException {
        System.out.println("\n*** CHỨC NĂNG CẬP NHẬT TỪ VỰNG ***\n");
        int functionId = 0;
        do {
            System.out.println("0. Quay trở lại trang chủ.");
            System.out.println("1. Cập nhật từ vựng.");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
            Scanner scanner = new Scanner(System.in);
            functionId = scanner.nextInt();
            switch (functionId) {
                case 0 -> {
                }
                case 1 -> {
                    System.out.println("Nhập khóa(key) slang word cần chỉnh sửa:");
                    String key = scanner.next();
                    if (htbKey.get(key.trim()) != null) {
                        System.out.println("Thông tin slang word:");
                        System.out.println(key.trim() + " có nghĩa là `" + htbKey.get(key.trim()) + "`");
                        System.out.println("Mời bạn nhập nghĩa mới cho slang word:");
                        scanner.nextLine();
                        String mean = scanner.nextLine();

                        //xử lý
                        String tMean = htbKey.get(key.trim());
                        String[] aOldMean = tMean.split("\\|");
                        String[] aNewMean = mean.trim().split("\\|");
                        GhiDeDuLieuMotDong(key.trim() + "`" + htbKey.get(key.trim()), key.trim() + "`" + mean);
                        // cập nhật cơ sở dữ liêu thành công
                        htbKey.put(key.trim(), mean.trim());
                        // xóa các nghĩa cũ có key này
                        for (String oldMean : aOldMean) {
                            if (htbMean.get(oldMean.trim()) != null) {
                                String temp = htbMean.get(oldMean.trim());
                                temp = temp.replace(key.trim(), "");
                                temp = temp.replace("``", "`");
                                if (temp.length() < 2) {
                                    temp = "";
                                    htbMean.remove(oldMean.trim());
                                } else {
                                    htbMean.put(oldMean.trim(), temp);
                                }
                            }
                        }
                        // cập nhật nghĩa mới
                        for (String newMean : aNewMean) {
                            if (htbMean.get(newMean.trim()) != null) {
                                String temp = htbMean.get(newMean.trim());
                                temp = temp + "`" + key.trim();
                                htbMean.put(newMean.trim(), temp);
                            } else {
                                htbMean.put(newMean.trim(), key.trim());
                            }
                        }
                        System.out.println("\n(^.^)Cập nhật từ vựng thành công(^.^).\n");

                    } else {
                        System.out.println("\n(`.`)Hệ thông không tìm thấy dữ liệu có khóa là `" + key + "` (`.`).\n");
                    }
                }
                default -> {
                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                    System.out.println("\n=============================THÔNG BÁO=============================");
                }
            }

        } while (functionId != 0);
    }

    private static void XoaMotTuVung(Hashtable<String, String> htbKey, Hashtable<String, String> htbMean) throws IOException {
        int functionId = 0;
        do {
            System.out.println("\n*** CHỨC NĂNG XÓA MỘT TỪ VỰNG ***\n");
            System.out.println("0. Quay lại trang chủ.");
            System.out.println("1. Xóa một từ vựng.");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
            Scanner scanner = new Scanner(System.in);
            functionId = scanner.nextInt();
            switch (functionId) {
                case 0 -> {
                }
                case 1 -> {
                    System.out.println("Mời bạn nhập khóa(key) slang word cần xóa:");
                    String key = scanner.next();
                    if (htbKey.get(key.trim()) != null) {
                        GhiDeDuLieuMotDong(key.trim() + "`" + htbKey.get(key.trim()), "");
                        String means = htbKey.get(key.trim()).trim();
                        String[] aMean = means.split("\\|");
                        htbKey.remove(key.trim());
                        for (String mean : aMean) {
                            String temp = htbMean.get(mean.trim());
                            temp = temp.replace(key.trim(), "");
                            temp = temp.replace("``", "`");
                            if (temp.length() < 2) {
                                temp = "";
                                htbMean.remove(mean.trim());
                            } else {
                                htbMean.put(mean.trim(), temp);
                            }
                        }
                        System.out.println("\n(^.^)Xóa từ vựng thành công(^.^).\n");
                    } else {
                        System.out.println("\n(`.`)Hệ thông không tìm thấy dữ liệu có khóa là `" + key + "` (`.`).\n");
                    }
                }
                default -> {
                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                    System.out.println("\n=============================THÔNG BÁO=============================");
                }
            }
        } while (functionId != 0);
    }

    private static void KhoiPhucCSDL(Hashtable<String, String> htbKey, Hashtable<String, String> htbMean) throws IOException {
        int functionId = 0;
        BackupDatabase bk = new BackupDatabase();
        do {
            System.out.println("*** CHỨC NĂNG KHÔI PHỤC CƠ SỞ DỮ LIỆU ***");
            System.out.println("0. Quay lại trang chủ.");
            System.out.println("1. Reset danh sách slang word về bản gốc(của thầy).");
            System.out.println("2. Khôi phục cơ sở dữ liệu về bản sao lưu(khi chương trình bắt đầu chạy hệ thông sinh ra 1 file backup).");
            System.out.println("MỜI BẠN CHỌN CHỨC NĂNG:");
            Scanner scanner = new Scanner(System.in);
            functionId = scanner.nextInt();
            switch (functionId) {
                case 0 -> {
                }
                case 1 -> {
                    bk.resetDatabase();
                    ReadFile r = new ReadFile();
                    htbKey.clear();
                    htbMean.clear();
                    r.ReadFileTXTIntoStructureData(htbKey, htbMean);
                    System.out.println("\n(^.^)Reset cơ sở dữ liệu thành công(^.^).\n");
                }
                case 2 -> {
                    bk.restoreDatabase();
                    ReadFile r = new ReadFile();
                    htbKey.clear();
                    htbMean.clear();
                    r.ReadFileTXTIntoStructureData(htbKey, htbMean);
                    System.out.println("\n(^.^)Khôi phục cơ sở dữ liệu thành công(^.^).\n");
                }
                default -> {
                    System.out.println("\n=============================THÔNG BÁO=============================");
                    System.out.println("Bạn nhập mã chức năng không đúng. Vui lòng nhập lại.");
                    System.out.println("\n=============================THÔNG BÁO=============================");
                }
            }
        } while (functionId != 0);
    }

    private static void HienThiNgauNhien(Hashtable<String, String> htbKey) {
        System.out.println("\n*** CHỨC NĂNG HIỂN THỊ NGẪU NHIÊN MỘT TỪ VỰNG ***\n");
        int len = htbKey.size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, len);
        List<String> listKey = new ArrayList<String>(htbKey.keySet());
        System.out.println("Tự vựng: ");
        System.out.println(listKey.get(randomNum) + " có nghĩa là `" + htbKey.get(listKey.get(randomNum)) + "`.");

    }

    private static void KyHieuTimNghia(Hashtable<String, String> htbKey) {
        System.out.println("\n^^^ CHƯƠNG TRINHG ĐỐ VUI ^^^\n");
        System.out.println("Mô tả: Chương trình cho trước một khóa(key) và hiện ra bốn đáp cho người dùng chọn.");
        Hashtable<Integer, Integer> htbNumber = new Hashtable<Integer, Integer>();
        int len = htbKey.size();
        do {
            int randomNum = ThreadLocalRandom.current().nextInt(0, len);
            if (htbNumber.get(randomNum) == null) {
                htbNumber.put(randomNum, randomNum);
            }
            if (htbNumber.size() == 4) {
                break;
            }
        } while (htbNumber.size() >= 0);
        List<Integer> listKeyNumBer = new ArrayList<Integer>(htbNumber.values());
        List<String> listKey = new ArrayList<String>(htbKey.keySet());
        System.out.println("Từ vựng có khóa(key) là: `" + listKey.get(listKeyNumBer.get(0)) + "`.");
        System.out.println("Hỏi nghĩa của khóa(key)là gì?");

        List<Integer> zeroToThree = new ArrayList<>();
        zeroToThree.add(0);
        zeroToThree.add(1);
        zeroToThree.add(2);
        zeroToThree.add(3);
        Collections.shuffle(zeroToThree);
        String ketqua = "";
        String[] alphabet = {"A", "B", "C", "D"};
        for (int i = 0; i < 4; i++) {
            if (zeroToThree.get(i) == 0) {
                ketqua = alphabet[i];
            }
            System.out.println(alphabet[i] + ". " + htbKey.get(listKey.get(listKeyNumBer.get(zeroToThree.get(i)))));
        }
        System.out.println("MỜI BẠN CHỌN ĐÁP ÁN");
        Scanner scanner = new Scanner(System.in);
        String dapAnNguoiChoi = scanner.next();
        dapAnNguoiChoi = dapAnNguoiChoi.trim().toUpperCase();
        System.out.println("Đáp án của ban tổ chức là: `" + ketqua + "`.");
        if (dapAnNguoiChoi.toString().trim().equals(ketqua.toString().trim())) {
            System.out.println("\n(^.^)Bạn trả lời ĐÚNG rồi. CHÚC MỪNG, CHÚC MỪNG, CHỨC MỪNG(^.^).\n");
        } else {
            System.out.println("\n(-.-)Bạn trả lời SAI rồi. THUA KEO NÀY TA BÀY KEO KHÁC NHA(-.-).\n");
        }
    }

    private static void NghiaTimKyHieu(Hashtable<String, String> htbKey, Hashtable<String, String> htbMean) {
        System.out.println("\n^^^ CHƯƠNG TRINHG ĐỐ VUI ^^^\n");
        System.out.println("Mô tả: Chương trình cho trước một nghĩa(definition) và hiện ra bốn đáp cho người dùng chọn.");
        int num1, num2, num3, num4;
        int len = htbMean.size();
        int lenKey = htbKey.size();
        int rdMean = ThreadLocalRandom.current().nextInt(0, len);

        List<String> listMean = new ArrayList<String>(htbMean.keySet());
        List<String> listKey = new ArrayList<String>(htbKey.keySet());

        System.out.println("Từ vựng có nghĩa(definition) là: `" + listMean.get(rdMean) + "`.");
        System.out.println("Hỏi Khóa(key) của nghĩa(definition)là gì?");

        String tam = htbMean.get(listMean.get(rdMean)).trim();
        String[] aKetQua = tam.split("`");

        List<Integer> zeroToThree = new ArrayList<>();
        zeroToThree.add(0);
        zeroToThree.add(1);
        zeroToThree.add(2);
        zeroToThree.add(3);
        Collections.shuffle(zeroToThree);
        String ketqua = "";
        String[] alphabet = {"A", "B", "C", "D"};
        for (int i = 0; i < 4; i++) {
            if (zeroToThree.get(i) == 0) {
                ketqua = alphabet[i];
                System.out.println(alphabet[i] + ". " + aKetQua[0]);
            } else {
                do {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, lenKey);
                    String temp = listKey.get(randomNum).trim();
                    if(temp.trim().equals(aKetQua[0].trim()) == false){
                         System.out.println(alphabet[i] + ". " + temp);
                         break;
                    }
                } while (1 == 1);
            }
        }
        System.out.println("MỜI BẠN CHỌN ĐÁP ÁN");
        Scanner scanner = new Scanner(System.in);
        String dapAnNguoiChoi = scanner.next();
        dapAnNguoiChoi = dapAnNguoiChoi.trim().toUpperCase();
        System.out.println("Đáp án của ban tổ chức là: `" + ketqua + "`.");
        if (dapAnNguoiChoi.toString().trim().equals(ketqua.toString().trim())) {
            System.out.println("\n(^.^)Bạn trả lời ĐÚNG rồi. CHÚC MỪNG, CHÚC MỪNG, CHỨC MỪNG(^.^).\n");
        } else {
            System.out.println("\n(-.-)Bạn trả lời SAI rồi. THUA KEO NÀY TA BÀY KEO KHÁC NHA(-.-).\n");
        }
    }

    private static void println(IOException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

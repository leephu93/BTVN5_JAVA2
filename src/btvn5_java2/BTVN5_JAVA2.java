package btvn5_java2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BTVN5_JAVA2 {

    static Scanner scanner = new Scanner(System.in);

    public static void C123() {
        File link = new File("E:\\JAVA\\JAVA2\\BTVN5_JAVA2\\src\\files");
        if (link.exists()) {
            if (link.isFile()) {
                System.out.println("ĐƯỜNG DẪN FILE.OK!");
                System.out.println(link.getPath());
                System.out.println(link.getName());
            } else {
                System.out.println("ĐƯỜNG DẪN THƯ MỤC THÔI!");
                System.out.println(link.getPath());
                System.out.print("Giới hạn size của file (KB): ");
                float n = scanner.nextFloat();
                for (File item : link.listFiles()) {
//                    if (item.getName().contains(".java")) {
//                        System.out.println(item.getName());
//                        System.out.println((double) item.length() / 1024 + " KB");
//                    }
                    float format_num = (float) item.length() / 1024;
                    if (format_num > n) {
                        System.out.println(item.getName());
                    }
                }
            }
        } else {
            System.out.println("ĐƯỜNG DẪN FILE KO TỒN TẠI.");
        }
    }

    public static void C4() throws FileNotFoundException, IOException {
        System.out.print("YOUR SOURCE: ");
        String source = scanner.nextLine();
        File link1 = new File(source);
        if (link1.exists()) { // Kiểm tra sự tồn tại của cả đường dẫn hiện tại
            if (link1.isFile()) { // Kiểm tra đường dẫn hiện tại có phải là File không?
                String old_nameFILE = link1.getName();
                String new_nameFILE = "";
                try (FileReader fr = new FileReader(link1)) {
                    File link2 = new File("E:\\JAVA\\JAVA2\\BTVN5_JAVA2\\src\\destination\\");
                    File link3;
                    boolean ckFILE = false;
                    int c;
                    for (File item : link2.listFiles()) { // Kiểm tra sự tồn tại của file hiện tại đã có trong thư mục destination chưa?
                        if (item.getName().equals(old_nameFILE)) {
                            ckFILE = true;
                        }
                    }
                    if (ckFILE) {
                        Date date = new Date();
                        new_nameFILE = "copy" + date.getTime() + " - " + old_nameFILE;
                        link3 = new File("E:\\JAVA\\JAVA2\\BTVN5_JAVA2\\src\\destination\\" + new_nameFILE);

                    } else {
                        link3 = new File("E:\\JAVA\\JAVA2\\BTVN5_JAVA2\\src\\destination\\" + old_nameFILE);
                    }
                    try (FileWriter fw = new FileWriter(link3)) {
                        while ((c = fr.read()) != -1) {
                            System.out.print((char) c);
                            fw.write((char) c);
                        }
                        System.out.println();
                        fw.write(" XXX ");
                    }
                    try (FileReader fr_new = new FileReader(link3)) {
                        while ((c = fr_new.read()) != -1) {
                            System.out.print((char) c);
                        }
                    }
                }
                System.out.println();
            } else {
                System.out.println("ONLY EXIST FOLDER");
            }
        } else {
            System.out.println("NOT EXIST");
        }
    }

    public static void C5() throws FileNotFoundException, IOException {
        System.out.print("YOUR SOURCE: ");
        String source = scanner.nextLine();
        File link = new File(source);
        if (link.exists()) {
            if (link.isFile()) {
                if (link.getName().contains(".txt") || link.getName().contains(".doc")) {
                    Path path = Paths.get(source);
                    Charset charset = Charset.forName("UTF-8");
                    int total_word = 0;
                    List<String> lines = Files.readAllLines(path, charset);
                    int num_line = 0;
                    for (String line : lines) {
                        if (line.length() != 0) {
                            line = line.trim();
                            String[] term = line.split(" ");
                            total_word += term.length;
                        }
                        num_line++;
                        System.out.println("Line " + num_line + " : " + line);
                        char[] ar_char = line.toCharArray();
                        for (int i = 0; i < ar_char.length; i++) {
                            System.out.println((char) ar_char[i]);
                        }
                    }
                    System.out.println("SỐ LƯỢNG TỪ TRONG FILE HIỆN TẠI: " + total_word);
                } else {
                    System.out.println("THIS FILE IS NOT A TEXT FILE");
                }
            } else {
                System.out.println("ONLY EXIST FOLDER");
            }
        } else {
            System.out.println("NOT EXIST");
        }
    }

    public static void C6() throws FileNotFoundException, IOException {
        System.out.print("YOUR SOURCE: ");
        String source = scanner.nextLine();
        System.out.print("FIND A CHARACTER: ");
        String character = scanner.nextLine();
        File link = new File(source);
        if (link.exists()) {
            if (link.isFile()) {
                if (link.getName().contains(".txt") || link.getName().contains(".doc")) {
                    if (character.length() < 2) {
                        Path path = Paths.get(source);
                        Charset charset = Charset.forName("UTF-8");
                        List<String> lines = Files.readAllLines(path, charset);
                        int count = 0;
                        for (String line : lines) {
                            if (line.length() != 0) {
                                char[] ar_char = line.toCharArray();
                                for (int i = 0; i < ar_char.length; i++) {
                                    if (((char) ar_char[i]) == character.charAt(0)) {
                                        count++;
                                    }
                                }
                            }
                        }
                        System.out.println("RESULT: " + count);
                    } else {
                        System.out.println("THE VALUE NEED TO FIND THAT IT IS NOT A CHARACTER ");
                    }
                } else {
                    System.out.println("THIS FILE IS NOT A TEXT FILE");
                }
            } else {
                System.out.println("ONLY EXIST FOLDER");
            }
        } else {
            System.out.println("NOT EXIST");
        }
    }

    public static void C7() throws FileNotFoundException, IOException {
        ArrayList<STUDENT> ar_students = new ArrayList<>();
        File f = new File("E:\\JAVA\\JAVA2\\BTVN5_JAVA2\\src\\files\\file9.txt");
        try (FileReader fr = new FileReader(f); LineNumberReader lines = new LineNumberReader(fr)) {
            String line = "";
            while ((line = lines.readLine()) != null) {
//                System.out.println(line);
                String[] term = line.split("@");
                STUDENT std = new STUDENT();
                std.setName(term[0]);
                std.setName_class(term[1]);
                std.setMark(Float.parseFloat(term[2]));
                ar_students.add(std);
            }
//            System.out.println(lines.getLineNumber());
        }
        for (STUDENT item : ar_students) {
            System.out.println("FULLNAME OF STUDENT: " + item.getName());
            System.out.println("NAMECLASS OF STUDENT: " + item.getName_class());
            System.out.println("MARK OF STUDENT: " + item.getMark());
            System.out.println("**********************");
        }
        System.out.print("FIND FOLLOW MARK: ");
        float mark = scanner.nextFloat();
        System.out.println("RESULT: ");
        for (STUDENT item : ar_students) {
            if (item.getMark() >= mark) {
                System.out.println("FULLNAME OF STUDENT: " + item.getName());
                System.out.println("NAMECLASS OF STUDENT: " + item.getName_class());
                System.out.println("MARK OF STUDENT: " + item.getMark());
                System.out.println("**********************");
            }
        }
        STUDENT std1 = new STUDENT();
        for (STUDENT item : ar_students){
            if(item.getMark() > std1.getMark()){
                std1.setName(item.getName());
                std1.setName_class(item.getName_class());
                std1.setMark(item.getMark());
            }
        }
        System.out.println("THE STUDENT HAS A MAX MARK !");
        System.out.println("FULLNAME OF STUDENT: " + std1.getName());
        System.out.println("NAMECLASS OF STUDENT: " + std1.getName_class());
        System.out.println("MARK OF STUDENT: " + std1.getMark());
        STUDENT std2 = (STUDENT) ar_students.get(0);
        for (STUDENT item : ar_students){
            if(item.getMark() < std2.getMark()){
                std2.setName(item.getName());
                std2.setName_class(item.getName_class());
                std2.setMark(item.getMark());
            }
        }
        System.out.println("THE STUDENT HAS A MIN MARK !");
        System.out.println("FULLNAME OF STUDENT: " + std2.getName());
        System.out.println("NAMECLASS OF STUDENT: " + std2.getName_class());
        System.out.println("MARK OF STUDENT: " + std2.getMark());
    }

    public static void main(String[] args) throws IOException {
//        C123();
//        C4();
//        C5();
//        C6();
        C7();
    }

}

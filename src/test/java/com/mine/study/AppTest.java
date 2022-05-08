package com.mine.study;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class AppTest {
    public static void main(String[] args) throws IOException {
        mdTable();
    }

    public static void mdTable() throws IOException {
        File myFile = new File("src/main/java/com/mine/study/medium/medium.md");

        if (myFile.isFile() && myFile.exists()) {

            InputStreamReader reader = new InputStreamReader(Files.newInputStream(myFile.toPath()), StandardCharsets.UTF_8);
            BufferedReader buf = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            PrintWriter pw = null;
            //记录替换所在的行
            int rowLine = 0;
            //换行符
            String enter = System.getProperty("line.separator");

            String line = null;
            StringBuilder mergeLine = null;
            int idx = 0;
            while ((line = buf.readLine()) != null) {
                rowLine++;

                if (line.contains(". ")) {
                    idx = 0;
                    mergeLine = new StringBuilder(enter + "| " + line);
                } else if ((line.startsWith("   ") || line.startsWith("    ") || line.startsWith("     ") || line.startsWith("      ")) && mergeLine != null) {
                    idx++;
                    mergeLine.append(" | ").append(line);
                }else {
                    sb.append(line).append(enter);
                }

                //数据暂存在 StringBuilder 中
                if (idx == 3) {
                    sb.append(mergeLine).append(" | ");
                }
            }

            buf.close();
            reader.close();

            // 修改原文件
            pw = new PrintWriter(new FileWriter(myFile), true);
            pw.print(sb);
            pw.flush();
            pw.close();

        } else {
            System.out.println("找不到指定的文件");
        }
    }

    public static void addTab() throws IOException {
        File myFile = new File("src/main/java/com/mine/study/hard/hard.md");

        if (myFile.isFile() && myFile.exists()) {

            InputStreamReader reader = new InputStreamReader(Files.newInputStream(myFile.toPath()), StandardCharsets.UTF_8);
            BufferedReader buf = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            PrintWriter pw = null;
            //记录替换所在的行
            int rowLine = 0;
            //换行符
            String enter = System.getProperty("line.separator");

            String line = null;
            while ((line = buf.readLine()) != null) {
                rowLine++;

                if (line.contains(". ")) {
                    System.out.println(line);
                } else if (!line.startsWith("    ") && rowLine > 10) {
                    System.out.println(line + " //需要修改");
                    line = "    " + line;
                } else {
                    System.out.println("不需要修改");
                }

                //数据暂存在 StringBuilder 中
                if (rowLine == 1) {
                    sb.append(line);
                } else {
                    sb.append(enter).append(line);
                }
            }

            buf.close();
            reader.close();

            // 写入新的文件
            //            BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get("data/out.json")));
            //            out.flush();
            //            out.close();

            // 修改原文件
            pw = new PrintWriter(new FileWriter(myFile), true);
            pw.print(sb);
            pw.flush();
            pw.close();

        } else {
            System.out.println("找不到指定的文件");
        }
    }
}

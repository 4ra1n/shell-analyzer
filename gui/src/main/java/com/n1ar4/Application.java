package com.n1ar4;

import com.n1ar4.form.ShellForm;

import javax.swing.*;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        checkJDK();
        Path outLogPath = new File("shell-analyzer-out.log").toPath();
        Path errLogPath = new File("shell-analyzer-err.log").toPath();
        try {
            System.setOut(new PrintStream(Files.newOutputStream(outLogPath)));
            System.setErr(new PrintStream(Files.newOutputStream(errLogPath)));
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    Files.delete(outLogPath);
                } catch (Exception ignored) {
                }
                try {
                    Files.delete(errLogPath);
                } catch (Exception ignored) {
                }
                try {
                    Files.delete(Paths.get("test.class"));
                } catch (Exception ignored) {
                }
            }));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ShellForm.start0();
    }

    public static void checkJDK() {
        JavaCompiler c = ToolProvider.getSystemJavaCompiler();
        if (c == null) {
            JOptionPane.showMessageDialog(null, "请使用JDK启动（目前是JRE）");
            System.exit(0);
        }
    }
}

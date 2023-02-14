package com.n1ar4;

import com.sun.tools.attach.VirtualMachine;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoteLoader {
    public static void main(String[] args) {
        checkJDK();
        if (args.length != 2) {
            System.out.println("usage: " +
                    "\tjava -cp remote.jar:/jdk/lib/tools.jar com.n1ar4.RemoteLoader [PID] [TOKEN]");
            return;
        }
        String pid = args[0];
        String password =args[1];
        System.out.println("attach pid: "+pid);
        System.out.println("password: " + password);
        try {
            VirtualMachine vm = VirtualMachine.attach(pid);
            Path agentPath = Paths.get("agent.jar");
            String path = agentPath.toAbsolutePath().toString();
            vm.loadAgent(path,password);
            vm.detach();
            System.out.println("success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void checkJDK() {
        JavaCompiler c = ToolProvider.getSystemJavaCompiler();
        if (c == null) {
            System.out.println("请使用JDK启动（目前是JRE）");
            System.exit(0);
        }
    }
}

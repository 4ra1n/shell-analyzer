package com.n1ar4.cmd;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        String path = "D:\\JavaCode\\shell-analyzer\\agent\\target\\RepairAgent-jar-with-dependencies.jar";
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor v:list){
            if(v.displayName().contains("org.apache.catalina.startup.Bootstrap")){
                System.out.println(v.displayName());
                VirtualMachine vm = VirtualMachine.attach(v.id());
                // 将我们的 agent.jar 发送给虚拟机
                vm.loadAgent(path);
                vm.detach();
            }
        }
    }
}

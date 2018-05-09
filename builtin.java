import jdk.jshell.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

    }
    boolean isBuiltin(Command command) {
        String str = command.name;
        if (str.equals("exit") || str.equals("history") || str.equals("status") || str.equals("cd")) {
            return true;
        } else {
            return false;
        }
    }
    boolean tryBuiltin(Command command) {
        String str = command.name;
        if (str.equals("exit")) {
            return exit(command);
        } else if (str.equals("ls")){
            return ls(command);
        } else if (str.equals("history")) {
            return history(command);
        } else if (str.equals("cd")) {
            return cd(command);
        } else if (str.equals("status")) {
            return status(command);
        } else {
            return false;
        }
        return true;
    }
    boolean exit(Command command) throws java.io.IOException, java.lang.InterruptedException{
        // Get runtime
        Runtime rt = Runtime.getRuntime();
        // Start a new process: UNIX command ls
        String cmd = "exit";
        //execute the command
        Process p = rt.exec(cmd);
        return true;
    }
    boolean history(Command command) throws java.io.IOException, java.lang.InterruptedException {
        // Get runtime
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        // Start a new process: UNIX command ls
        java.lang.Process p = rt.exec("history");
        // You can or maybe should wait for the process to complete
        p.waitFor();
        // Get process' output: its InputStream
        java.io.InputStream is = p.getInputStream();
        java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
        // And print each line
        String s = null;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        is.close();
        if (p.exitValue() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    boolean ls(Command command) throws java.io.IOException, java.lang.InterruptedException {
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        java.lang.Process p = rt.exec("ls");
        p.waitFor();
        java.io.InputStream is = p.getInputStream();
        java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
        String s = null;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        is.close();
        if (p.exitValue() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    boolean status(Command command) throws java.io.IOException, java.lang.InterruptedException{
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        java.lang.Process p = rt.exec("history");
        p.waitFor();
        java.io.InputStream is = p.getInputStream();
        java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is));
        String s = null;
        String cd = "";
        while ((s = reader.readLine()) != null) {
            cd = s;
        }
        System.out.println(cd);
        is.close();
        if (p.exitValue() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    boolean cd(Command command) throws java.io.IOException, java.lang.InterruptedException{
        Runtime rt = Runtime.getRuntime();
        String arg = command.argument;
        if (argument == null || argument.equals("")) {
            System.out.println("input error");
        }
        String[] cmd = {"cd",arg};
        Process p = rt.exec(cmd);
        return true;
    }

}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Builtin {
	/**
	 * * A:获取功能
	 * public String getAbsolutePath()：获取绝对路径
	 * public String getPath():获取路径
	 * public String getName():获取名称
	 * public long length():获取长度。字节数
	 * public long lastModified():获取最后一次的修改时间，毫秒值
	 * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
	 * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
	 */
	static File dir = new File("/Users/wentingzhu");
	static File[] list = (new File("/Users/wentingzhu")).listFiles();

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		ArrayList<String> history = new ArrayList<>();

		System.out.println("Welcom! What can I do for you?");
		boolean over = false;
		while(true) {
			System.out.print("slugshell>> ");
			String string = sc.nextLine();
			String[] commend  = string.split("\\u007C");
			for (String subString : commend) {
				over = builtinCommend(history, over, subString.trim());
			}
			if(over) break;
			history.add(string);
		}
 	}
	static File dir = new File("/Users/wentingzhu");
	static File[] list = (new File("/Users/wentingzhu")).listFiles();

	public static boolean isBuiltinCommend(String string) {
		if(string.equals("ls") || string.startsWith("ls *") || string.equals("history") || string.equals("status") || string.equals("cd ..")
				|| string.equals("cd ~") || string.startsWith("cd") || string.equals("pwd") || string.equals("quit") || string.startsWith("mv ")
				|| string.startsWith("cp ")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean builtinCommend(ArrayList<String> history, boolean over, String string) {
		if(string.equals("ls")) {
			list();
		}else if(string.startsWith("ls *")){
			list(string);
		}else if(string.equals("history")) {
			history(history);
		}else if(string.equals("status")){
			System.out.println(history.get(history.size()-1));
		}else if(string.equals("cd ..")) {
			goback();
		}else if(string.equals("cd ~")){
			home();
		}else if(string.startsWith("cd ")) {
			cd(string);
		}else if(string.startsWith("mv ") || string.startsWith("cp ")){
			change(string);
		}else if(string.equals("pwd")) {
			System.out.println(dir);
		}else if(string.equals("quit")){
			System.out.println("See you！");
			over = true;
		}
		return over;
	}

	public static void change(String string) {
		String[] fs = string.substring(3).split(" ");
		if(fs.length != 2) {
			System.out.println("You should input like: mv/cp aFile bFile");
		}else {
			File original = new File(dir, fs[0]);
			File newFile = new File(dir,fs[1]);
			System.out.println(original.renameTo(newFile));
			if(string.startsWith("cp "))copyFile(newFile , original);
		}
	}

	public static void history(ArrayList<String> history) {
		for (int i = 0; i < history.size(); i++) {
			System.out.println(i + 1 + "." + history.get(i));
		}
	}
	
	public static void copyFile(File fromFile,File toFile){
        try {
        	FileInputStream ins = new FileInputStream(fromFile);
            FileOutputStream out = new FileOutputStream(toFile);
            byte[] b = new byte[1024];
            int n=0;
            while((n=ins.read(b))!=-1){
                out.write(b, 0, n);
            }
            
            ins.close();
            out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

	public static void home() {
		dir = new File("/Users/wentingzhu");
		list = (new File("/Users/wentingzhu")).listFiles();
	}


	public static void list(String string) {
		for (File file : list) {					//获取文件对象
			if(file.getName().endsWith(string.substring(4)))System.out.println(file);
		}
	}

	public static void goback() {
		try {
			dir = dir.getParentFile();
			list = dir.listFiles();
		} catch (Exception e) {
			System.out.println("It is root now");
			dir = new File("/Users/wentingzhu");
		}
	}

	public static void cd(String string) {
		String cd  = string.substring(3);
		for(File subFile : list) {
			if(subFile.isFile())continue;
			if(subFile.getName().equals(cd)) {
				dir = subFile;
				list = dir.listFiles();
				return;
			}
		}
		System.out.println("Folder doesn't exist!");
	}

	public static void list() {
		for (File file : list) {					//获取文件对象
			System.out.println(file);
		}
	}
}

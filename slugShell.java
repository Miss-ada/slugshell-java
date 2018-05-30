import java.io.*;
import java.text.*;
import java.util.*;

public class slugShell{
    public static void main(String[] args) {
        ArrayList<String> history = new ArrayList<>();
        boolean over = false;

        System.out.println("Welcome! What can I do for you?");
        System.out.print("slugshell>> ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String string = sc.nextLine();
            String new_s = string.replace("\n", "");
            InputStream in = new ByteArrayInputStream(new_s.getBytes());
            MyNewGrammar parser = new MyNewGrammar(in);
            try {
                //Command result = parser.parseFile();
                Command result = parser.parseFile();
                System.out.println("file parsed successfully.");
                System.out.println(result);
                Builtin built;
                built = new Builtin();
                for (SingleCommand c : result.pipe_list) {
                    String str = c.cmd;
                    for (String s : c.args) {
                        str += " " + s;
                    }
                    if (built.isBuiltinCommend(str)) {
                        built.builtinCommend(history, over, str);
                    }
                    if (over) break;
                    history.add(str);
                }
            } catch (ParseException e) {
                System.out.println(e.toString());
            }
        }
    }
}
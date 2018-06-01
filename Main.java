import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException  {
        ArrayList<String> history = new ArrayList<>();
        boolean over = false;

        System.out.println("Welcome! What can I do for you?");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("slugshell>> ");
            String string = sc.nextLine();
            String new_s = string.replace("\n", "");
            InputStream in = new ByteArrayInputStream(new_s.getBytes());
            MyNewGrammar parser = new MyNewGrammar(in);
            try {
                Command result = parser.parseFile();
//                Builtin built;
//                built = new Builtin();
                java.lang.Runtime rt = java.lang.Runtime.getRuntime();
                int n = result.pipe_list.size();
                java.lang.Process[] processes = new java.lang.Process[n];
//                for (SingleCommand c : result.pipe_list) {
                for (int i = 0; i < n; i++){
                    SingleCommand c = result.pipe_list.get(i);
                    String str = c.cmd;
                    for (String s : c.args) {
                        str += " " + s;
                    }
                    java.lang.Process p = rt.exec(str);
                    processes[i] = p;
//                    if (built.isBuiltinCommend(str)) {
//                        built.builtinCommend(history, over, str);
//                    }
//
//                    if (over) break;
//                    history.add(str);
//                }
                }
                // Start piping
                java.io.InputStream input = Piper.pipe(processes);
                // Show output of last process
                java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(input));
                String s = null;
                while ((s = r.readLine()) != null) {
                    System.out.println(s);
                }

            } catch (ParseException e) {
                System.out.println(e.toString());
            }
        }
    }
}

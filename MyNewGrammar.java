/* Generated By:JavaCC: Do not edit this line. MyNewGrammar.java */
import java.io.*;
import java.util.*;


public class MyNewGrammar implements MyNewGrammarConstants {
  public static void main(String args []) throws ParseException
  {
        MyNewGrammar parser = new MyNewGrammar(System.in);
    try {
        //Command result = parser.parseFile();
        parser.parseFile();
        System.out.println("file parsed successfully.");
                //System.out.println(result); 
      }
      catch(ParseException e){
        System.out.println(e.toString());
      }
  }

/* PARSING */
//return an object from javacc
  static final public Command parseFile() throws ParseException {
  Command command_line;
    p_command_line();
                  command_line = p_command_line();
    jj_consume_token(0);
         {if (true) return command_line;}
    throw new Error("Missing return statement in function");
  }

  static final public Command p_command_line() throws ParseException {
  List<SingleCommand> pipe_list = new ArrayList<SingleCommand>();
  List<ArrayList<String>> io_modifier_list = new ArrayList<ArrayList<String>>();
// background_opt = 1 if run in background/[&]
 int background_opt = 0;
    p_pipe_list();
                        pipe_list = p_pipe_list();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GREAT:
    case LESS:
    case GREATGREAT:
    case GREATAMPERSAND:
      p_io_modifier_list();
                                                                             io_modifier_list = p_io_modifier_list();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    p_background_opt();
                                                                                                                                              background_opt = p_background_opt();
   {if (true) return new Command(pipe_list, io_modifier_list, background_opt);}
    throw new Error("Missing return statement in function");
  }

  static final public List<SingleCommand> p_pipe_list() throws ParseException {
  List<SingleCommand> pipe_list = new ArrayList<SingleCommand>();
  SingleCommand sc;
  SingleCommand psc;
    sc = p_cmd_and_args();
                          pipe_list.add(sc);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PIPE:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(PIPE);
      psc = p_cmd_and_args();
                                    pipe_list.add(psc);
    }
   {if (true) return pipe_list;}
    throw new Error("Missing return statement in function");
  }

  static final public SingleCommand p_cmd_and_args() throws ParseException {
  Token cmd ;
  List<String> args = new ArrayList<String>();
  Token arg;
    cmd = jj_consume_token(WORD);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      arg = jj_consume_token(WORD);
                               args.add(arg.image);
    }
                                                        {if (true) return new SingleCommand(cmd.image, args);}
    throw new Error("Missing return statement in function");
  }

  static final public List<ArrayList<String>> p_io_modifier_list() throws ParseException {
  List<ArrayList<String>> io_modifiers = new ArrayList<ArrayList<String>>();
  ArrayList<String > io_modifier;
    label_3:
    while (true) {
      io_modifier = p_io_modifier();
                                  io_modifiers.add(io_modifier);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GREAT:
      case LESS:
      case GREATGREAT:
      case GREATAMPERSAND:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
    }
     {if (true) return io_modifiers;}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<String> p_io_modifier() throws ParseException {
  ArrayList<String> io_modifier = new ArrayList<String>();
  Token dir;
  Token filename;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GREAT:
      dir = jj_consume_token(GREAT);
      filename = jj_consume_token(WORD);
                                       io_modifier.add(dir.image); io_modifier.add(filename.image);{if (true) return io_modifier;}
      break;
    case GREATGREAT:
      dir = jj_consume_token(GREATGREAT);
      filename = jj_consume_token(WORD);
                                           io_modifier.add(dir.image); io_modifier.add(filename.image);{if (true) return io_modifier;}
      break;
    case GREATAMPERSAND:
      dir = jj_consume_token(GREATAMPERSAND);
      filename = jj_consume_token(WORD);
                                               io_modifier.add(dir.image); io_modifier.add(filename.image);{if (true) return io_modifier;}
      break;
    case LESS:
      dir = jj_consume_token(LESS);
      filename = jj_consume_token(WORD);
                                     io_modifier.add(dir.image); io_modifier.add(filename.image);{if (true) return io_modifier;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public int p_background_opt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AMPERSAND:
      jj_consume_token(AMPERSAND);
               {if (true) return 1;}
      break;
    case 0:
      jj_consume_token(0);
         {if (true) return 0;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MyNewGrammarTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1e0,0x200,0x800,0x1e0,0x1e0,0x401,};
   }

  /** Constructor with InputStream. */
  public MyNewGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyNewGrammar(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MyNewGrammar(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MyNewGrammar(MyNewGrammarTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MyNewGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[12];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 12; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

 }
import java.util.ArrayList;
import java.util.List;

public class Command {
	List<SingleCommand> pipe_list;
	List<ArrayList<String>> io_list;
	int background_opt;
	
	public Command(List<SingleCommand> pipe, List<ArrayList<String>> io, int back){
		pipe_list = pipe;
		io_list = io;
		background_opt = back;
		
	}
}

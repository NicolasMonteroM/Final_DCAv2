package exceptions;

public class UnvalidNickname  extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnvalidNickname(){
		super("Please write a nickname to save your score");
	}
}

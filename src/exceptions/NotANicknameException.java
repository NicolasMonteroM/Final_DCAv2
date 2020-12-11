package exceptions;

public class NotANicknameException  extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotANicknameException(){
		super("Be a little bit more creative");
	}
}

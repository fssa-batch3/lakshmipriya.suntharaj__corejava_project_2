package Recipe.validation.exception;

public class InValidRecipeException extends Exception{
	private static final long serialVersionUID = -1194860954774008955L;

	public InValidRecipeException(String msg) {
		super(msg);
	}

	public InValidRecipeException(Throwable e) {
		super(e);
	}
}

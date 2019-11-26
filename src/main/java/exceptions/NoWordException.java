package exceptions;

public class NoWordException extends RuntimeException {
	
	public NoWordException(String errorMessage)
	{
		System.err.print(errorMessage);
	}

}

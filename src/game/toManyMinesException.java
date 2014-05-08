package game;

public class toManyMinesException extends RuntimeException {
	
	public toManyMinesException() {
		System.out.println("The number of mines cannot exceed the number of squares");
	}

}

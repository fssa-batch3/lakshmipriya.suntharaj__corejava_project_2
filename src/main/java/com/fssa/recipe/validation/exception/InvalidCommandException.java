package com.fssa.recipe.validation.exception;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidCommandException(String msg) {
		super(msg);
	}

	public InvalidCommandException(Throwable e) {
		super(e);
	} 
}

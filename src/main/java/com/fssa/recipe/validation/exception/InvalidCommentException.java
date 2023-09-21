package com.fssa.recipe.validation.exception;

public class InvalidCommentException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidCommentException(String msg) {
		super(msg);
	}

	public InvalidCommentException(Throwable e) {
		super(e);
	} 
}

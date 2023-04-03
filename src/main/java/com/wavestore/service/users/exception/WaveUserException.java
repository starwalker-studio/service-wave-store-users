package com.wavestore.service.users.exception;

public class WaveUserException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int codeException;

	public WaveUserException(int codeException) {
		super();
		this.codeException = codeException;
	}

	@Override
	public String getMessage() {
		String userExceptionMessage = "";
		switch (codeException) {
		case 1001:
			userExceptionMessage = "EXISTING_WAVE_USER_1001";
			break;

		default:
			break;
		}
		return userExceptionMessage;
	}

}

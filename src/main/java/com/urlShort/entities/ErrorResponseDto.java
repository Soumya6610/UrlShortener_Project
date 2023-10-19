package com.urlShort.entities;

public class ErrorResponseDto {

	private String status;
	private String error;

	public ErrorResponseDto(String status, String error) {
		super();
		this.status = status;
		this.error = error;
	}

	public ErrorResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorResponseDto [status=" + status + ", error=" + error + "]";
	}

}

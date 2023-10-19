package com.urlShort.entities;

public class UrlDto {

	private String url;

	public UrlDto(String url) {
		super();
		this.url = url;
	}

	public UrlDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "UrlDto [url=" + url + "]";
	}

}

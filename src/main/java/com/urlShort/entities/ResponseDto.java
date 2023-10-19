package com.urlShort.entities;

public class ResponseDto {

	private String originalUrl;
	private String shortLink;

	public ResponseDto(String originalUrl, String shortLink) {
		super();
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	@Override
	public String toString() {
		return "ResponseDto [originalUrl=" + originalUrl + ", shortLink=" + shortLink + "]";
	}

}

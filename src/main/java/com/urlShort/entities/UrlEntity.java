package com.urlShort.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UrlEntity {

	@Id
	@GeneratedValue
	private long id;
	private String originalUrl;
	private String shortUrl;

	public UrlEntity(long id, String originalUrl, String shortUrl) {
		super();
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
	}

	public UrlEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	@Override
	public String toString() {
		return "UrlEntity [id=" + id + ", originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + "]";
	}

	
}

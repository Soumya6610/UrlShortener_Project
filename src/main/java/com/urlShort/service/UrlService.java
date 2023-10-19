package com.urlShort.service;

import org.springframework.stereotype.Service;

import com.urlShort.entities.UrlDto;
import com.urlShort.entities.UrlEntity;

@Service
public interface UrlService {

	public UrlEntity generateShortLink(UrlDto urlDto);

	public UrlEntity persistShortLink(UrlEntity urlEntity);

	public UrlEntity getEncodedUrl(String url);

	public void deleteShortLink(UrlEntity urlEntity);
}

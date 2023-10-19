package com.urlShort.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.urlShort.entities.UrlDto;
import com.urlShort.entities.UrlEntity;
import com.urlShort.repository.UrlRepository;

import io.micrometer.common.util.StringUtils;

@Component
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlRepository urlRepository;

	@Override
	public UrlEntity generateShortLink(UrlDto urlDto) {
		// TODO Auto-generated method stub

		if (StringUtils.isNotEmpty(urlDto.getUrl())) {
			String encodeUrl = encodeUrl(urlDto.getUrl());
			UrlEntity urlToPersist = new UrlEntity();
			urlToPersist.setOriginalUrl(urlDto.getUrl());
			urlToPersist.setShortUrl(encodeUrl);
			UrlEntity urlToRet = persistShortLink(urlToPersist);

			if (urlToRet != null)
				return urlToRet;

			return null;
		}
		return null;
	}

	private String encodeUrl(String url) {
		// TODO Auto-generated method stub

		String encodedUrl = "";
		encodedUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();

		return encodedUrl;
	}

	@Override
	public UrlEntity persistShortLink(UrlEntity urlEntity) {
		// TODO Auto-generated method stub

		UrlEntity urlToRet = urlRepository.save(urlEntity);
		return urlToRet;
	}

	@Override
	public UrlEntity getEncodedUrl(String url) {
		// TODO Auto-generated method stub

		UrlEntity urlToRet = urlRepository.findByShortUrl(url);

		return urlToRet;
	}

	@Override
	public void deleteShortLink(UrlEntity urlEntity) {
		// TODO Auto-generated method stub

		urlRepository.delete(urlEntity);

	}

}

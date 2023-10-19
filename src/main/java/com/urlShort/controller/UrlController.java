package com.urlShort.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.urlShort.entities.ErrorResponseDto;
import com.urlShort.entities.ResponseDto;
import com.urlShort.entities.UrlDto;
import com.urlShort.entities.UrlEntity;
import com.urlShort.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;

import io.micrometer.common.util.StringUtils;

@RestController
public class UrlController {

	@Autowired
	private UrlService urlService;

	@PostMapping("/shorten")
	public ResponseEntity<?> shortenUrl(@RequestBody UrlDto urlDto) {

		UrlEntity urlToRet = urlService.generateShortLink(urlDto);

		if (urlToRet != null) {
			ResponseDto responseDto = new ResponseDto();
			responseDto.setOriginalUrl(urlToRet.getOriginalUrl());
			responseDto.setShortLink(urlToRet.getShortUrl());

			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}

		ErrorResponseDto errorResponseDto = new ErrorResponseDto();
		errorResponseDto.setStatus("404");
		errorResponseDto.setError("there is an error processing your request, please try again!");

		return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.OK);
	}

	@GetMapping("/{shortLink}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response)
			throws IOException {

		if (StringUtils.isEmpty(shortLink)) {
			ErrorResponseDto errorResponseDto = new ErrorResponseDto();
			errorResponseDto.setError("Invalid URL");
			errorResponseDto.setStatus("400");
			return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.OK);
		}
		UrlEntity urlToRet = urlService.getEncodedUrl(shortLink);

		if (urlToRet == null) {
			ErrorResponseDto errorResponseDto = new ErrorResponseDto();
			errorResponseDto.setError("URL does not exist or expired");
			errorResponseDto.setStatus("400");
			return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.OK);
		}

		response.sendRedirect(urlToRet.getOriginalUrl());
		return null;
	}
}

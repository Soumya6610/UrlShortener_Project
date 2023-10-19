package com.urlShort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlShort.entities.UrlEntity;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

	public UrlEntity findByShortUrl(String shortUrl);
}

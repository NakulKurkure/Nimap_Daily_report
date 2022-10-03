package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CacheOperations {

	@Autowired
	private com.config.CacheConfig cacheConfig;

	public Boolean isKeyExist(String key1, String key2) {
		return cacheConfig.redisTemplate().opsForHash().hasKey(key1, key2);
	}

	public void addInCache(String key1, String key2, Object val) {
		cacheConfig.redisTemplate().opsForHash().put(key1, key2, val);
	}
	
	public Object getFromCache(String key1, String key2) {
		return cacheConfig.redisTemplate().opsForHash().get(key1, key2);
	}
	
	public void removeKeyFromCache(String key) {
		cacheConfig.redisTemplate().delete(key);
		return;
	}
	
	
}

package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.job.config.CacheConfig;



public class CacheOperation {

	@Autowired
	private CacheConfig cacheConfig;

	public CacheOperation() {
		super();
	}
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

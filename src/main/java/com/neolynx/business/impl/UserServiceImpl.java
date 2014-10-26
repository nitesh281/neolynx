package com.neolynx.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.neolynx.business.UserService;
import com.neolynx.domain.Cachable;
import com.neolynx.domain.impl.User;

@Service("userService")
public class UserServiceImpl implements UserService<User> {

	@Autowired
	RedisTemplate<String, Cachable> redisTemplate;

	public void put(User user) {
		redisTemplate.opsForHash()
				.put(user.getObjectKey(), user.getKey(), user);
	}

	public void delete(User key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	public User get(User key) {
		return (User) redisTemplate.opsForHash().get(key.getObjectKey(),
				key.getKey());
	}
}

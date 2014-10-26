package com.neolynx.business;

import com.neolynx.domain.Cachable;

public interface UserService<V extends Cachable> {

	public void put(V obj);

	public V get(V key);

	public void delete(V key);

}

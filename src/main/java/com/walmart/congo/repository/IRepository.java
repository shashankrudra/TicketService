package com.walmart.congo.repository;

import com.walmart.congo.model.AbstractEntity;

public interface IRepository {
	void registerEntity(AbstractEntity entity);

	boolean isRegistered(AbstractEntity entity);
}

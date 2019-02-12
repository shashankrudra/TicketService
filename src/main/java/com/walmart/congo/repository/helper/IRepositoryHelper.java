package com.walmart.congo.repository.helper;

import java.util.List;

public interface IRepositoryHelper {

	// void registerBulkCsvData(String[] csvDataLiney);

	// void registerCsvData(String csvDataLine);

	void saveEntity(List<String> fields);
}

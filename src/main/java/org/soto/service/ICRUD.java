package org.soto.service;

import java.util.List;

public interface ICRUD<T,ID> {

	List<T> findAll() throws Exception;

	T create(T obj) throws Exception;

	T findById(ID id) throws Exception;
	
	T update(T obj) throws Exception;

	void deleteById(ID id) throws Exception;

}
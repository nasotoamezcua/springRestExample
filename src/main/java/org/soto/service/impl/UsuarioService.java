package org.soto.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.soto.entity.Usuario;
import org.soto.repository.IUsuarioRepository;
import org.soto.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository dao;

	@Override
	public List<Usuario> findAll() throws Exception {
		return dao.findAll();
	}

	@Override
	public Usuario create(Usuario obj) throws Exception {
		return dao.save(obj);
	}

	@Override
	public Usuario findById(Long id) throws Exception {
		return dao.findOne(id);
	}

	@Override
	public Usuario update(Usuario obj) throws Exception {
		return dao.save(obj);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		dao.delete(id);
	}

}

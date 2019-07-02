package org.soto.api;

import java.util.List;

import org.soto.entity.Usuario;
import org.soto.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
	
	@Autowired
	private IUsuarioService service;
	
	//Buscar Todos los usuarios
	@GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> restFindAll() throws Exception{
		return new ResponseEntity<List<Usuario>>(service.findAll(), HttpStatus.OK);
	}
	
	//Buscar por id de usuario
	@GetMapping(path = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> restFindById(@PathVariable("id") Long id) throws Exception{
		return new ResponseEntity<Usuario>(service.findById(id), HttpStatus.OK);
	}
	
	//Crear usuario
	@PostMapping(path = "/crear", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> restCreate(@RequestBody Usuario usuario) throws Exception{
		return new ResponseEntity<Usuario>(service.create(usuario), HttpStatus.OK);
	}
	
	//Actualizar usuario
	@PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> restUpdate(@RequestBody Usuario usuario) throws Exception{
		return new ResponseEntity<Usuario>(service.update(usuario), HttpStatus.OK);
	}
	
	//Borrar  usuario
	@DeleteMapping(path = "/borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> restDelete(@RequestBody Usuario usuario) throws Exception{
		service.deleteById(usuario.getId());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}

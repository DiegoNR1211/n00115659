package pe.edu.delfines.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.delfines.models.entity.Cliente;

@Service
public interface ClienteService extends CrudService<Cliente, Integer>{
	//List<Cliente> fetchMedicos(String nombre) throws Exception;

}

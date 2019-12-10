package pe.edu.delfines;

import static org.assertj.core.api.Assertions.entry;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;

@SpringBootTest
class DelfinesApplicationTests {
	
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void contextLoads() {
		
		try {
			Tipo t1 = new Tipo();
			t1.setId("T1");
			t1.setNombre("Tipo 1");
			
			Tipo t2 = new Tipo();
			t2.setId("T2");
			t2.setNombre("Tipo 2");
			
			Float precio = Float.parseFloat("50");
			Habitacion h1 = new Habitacion();
			h1.setId(1);
			h1.setNumeroCamas(2);
			h1.setDescripcion("PoolDance");
			h1.setPrecio(precio);
			h1.setObservacion("Amplia");
			
			Habitacion h2 = new Habitacion();
			h2.setId(2);
			h2.setNumeroCamas(2);
			h2.setDescripcion("Jacuzzi");
			h2.setPrecio(precio);
			h2.setObservacion("Amplia");
			
			Alquiler a1 = new Alquiler();
			a1.setId(10);
			a1.setPrecio(precio);
			a1.setFecha_entrada(new Date(2019, 9, 9));
			a1.setFecha_salida(new Date(2019, 9, 9));
			a1.setEstado("Libre");
			a1.setObservacion("x");
			
			Alquiler a2 = new Alquiler();
			a2.setId(20);
			a2.setPrecio(precio);
			a2.setFecha_entrada(new Date(2019, 9, 19));
			a2.setFecha_salida(new Date(2019, 9, 19));
			a2.setEstado("Libre");
			a2.setObservacion("x");
			
			Cliente c1 = new Cliente();
			
			c1.setDocumento("N001");
			c1.setNombre("Juanito");
			c1.setFechaNacimiento(new Date(1950, 9, 19));
			c1.setLugarNacimiento("calle");
			c1.setSexo('m');
			c1.setObservacion("x");
			
			Cliente c2 = new Cliente();
			
			c2.setDocumento("N002");
			c2.setNombre("Juana");
			c2.setFechaNacimiento(new Date(1950, 9, 20));
			c2.setLugarNacimiento("calle123");
			c2.setSexo('f');
			c2.setObservacion("x");
			
			t1 = tipoRepository.save(t1);
			t2 = tipoRepository.save(t2);
			h1 = habitacionRepository.save(h1);
			h2 = habitacionRepository.save(h2);
			a1 = alquilerRepository.save(a1);
			a2 = alquilerRepository.save(a2);
			c1 = clienteRepository.save(c1);
			c2 = clienteRepository.save(c2);
			
			h1.setTipo(t1);
			h2.setTipo(t2);
			
			a1.setClientes(c1);
			a2.setClientes(c2);
			
			tipoRepository.save(t1);
			tipoRepository.save(t2);
			habitacionRepository.save(h1);
			habitacionRepository.save(h2);
			alquilerRepository.save(a1);
			alquilerRepository.save(a2);
			clienteRepository.save(c1);
			clienteRepository.save(c2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

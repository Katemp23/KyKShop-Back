package com.kawaiiTokioShop.kykshop.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.dto.CheckoutDto;
import com.kawaiiTokioShop.kykshop.dto.ProductoDto;
import com.kawaiiTokioShop.kykshop.enums.TipoIdentificacion;
import com.kawaiiTokioShop.kykshop.models.CiudadModel;
import com.kawaiiTokioShop.kykshop.models.FacturaModel;
import com.kawaiiTokioShop.kykshop.models.PedidoModel;
import com.kawaiiTokioShop.kykshop.models.PersonaModel;
import com.kawaiiTokioShop.kykshop.models.ProductoModel;
import com.kawaiiTokioShop.kykshop.models.ProductosFacturaModel;
import com.kawaiiTokioShop.kykshop.repositories.CiudadRepository;
import com.kawaiiTokioShop.kykshop.repositories.FacturaRepository;
import com.kawaiiTokioShop.kykshop.repositories.PedidoRepository;
import com.kawaiiTokioShop.kykshop.repositories.PersonaRepository;
import com.kawaiiTokioShop.kykshop.repositories.ProductoRepository;
import com.kawaiiTokioShop.kykshop.repositories.ProductosFacturaRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProductosFacturaRepository pFRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private CiudadRepository ciudadRepository;

    public List<PedidoModel> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> getPedidoById(int id) {
        return pedidoRepository.findById(id);
    }

    public PedidoModel savePedido(PedidoModel pedidoModel) {
        return pedidoRepository.save(pedidoModel);
    }

    public void deletePedido(int id) {
    	pedidoRepository.deleteById(id);
    }
    
    @Transactional
    public CheckoutDto createPedido(CheckoutDto pedido) {
    	
    	int contadorProductos = 0;
    	
    	//Busca la persona
    	List<PersonaModel> personas = personaRepository.findByIdentificacion(pedido.getIdNumber());
    	if (personas.isEmpty()) {
			PersonaModel personaModel = new PersonaModel();
			personaModel.setNombres(pedido.getFirstName());
			personaModel.setApellidos(pedido.getLastName());
			personaModel.setCorreo(pedido.getEmail());
			personaModel.setCodigoCiudad(Integer.valueOf(pedido.getCity()));
			personaModel.setDireccion(pedido.getAddress());
			personaModel.setIdCargo(1);
			personaModel.setIdentificacion(pedido.getIdNumber());
			personaModel.setIdTipoPersona("1");
			personaModel.setTelefono(pedido.getPhone());
			personaModel.setTipoId(pedido.getIdType());
			personas.add(personaRepository.save(personaModel));
		}
    	
    	//Crea el pedido
    	PedidoModel pedidoModel = new PedidoModel();
    	pedidoModel.setCantidadSolicitada(pedido.getCarts().size());
    	pedidoModel.setEstadoPedido("PREPARADO");
    	pedidoModel.setFechaPedido(LocalDateTime.now());
    	pedidoModel.setIdPersona(personas.get(0).getIdPersona());
    	//pedidoModel = pedidoRepository.save(pedidoModel);
    	
    	//Crea la factura
    	FacturaModel factura = new FacturaModel();
    	factura.setCantidadVendida(pedido.getCarts().size());
    	factura.setCVVTarjeta(pedido.getCvv());
    	factura.setEstadoFactura("COMPLETA");
    	factura.setFechaFactura(LocalDateTime.now());
    	factura.setFVTarjeta(pedido.getExpiryDate());
    	factura.setIdPedido(pedidoModel.getIdPedido());
    	factura.setIdPersona(personas.get(0).getIdPersona());
    	factura.setNumeroTarjeta(pedido.getCardNumber());
    	factura.setVrlTotal(pedido.getTotal());
    	//factura = facturaRepository.save(factura);
    	
    	//Crea los productos de la factura
    	for (ProductoDto cart : pedido.getCarts()) {
        	Optional<ProductoModel> optionalProducto = productoRepository.findById(cart.getId());
        	ProductoModel producto = optionalProducto.orElse(new ProductoModel()); 
        	ProductosFacturaModel prodFac = new ProductosFacturaModel();
            BeanUtils.copyProperties(producto, prodFac);
            prodFac.setCantidad(cart.getQuantity());
            prodFac.setIdFactura(factura.getIdFactura());
           // prodFac = pFRepository.save(prodFac);
            contadorProductos = contadorProductos + cart.getQuantity();
		}
    	
    	pedido.setIdFactura(factura.getIdFactura());
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	pedido.setDateFactura(factura.getFechaFactura().format(formatter));
    	pedido.setIdType(TipoIdentificacion.valueOf(pedido.getIdType()).getDescripcion());
    	CiudadModel ciudadModel = ciudadRepository.findById(Integer.valueOf(pedido.getCity())).orElse(new CiudadModel());
    	pedido.setCity(ciudadModel.getNombre());
    	pedido.setItemsCount(contadorProductos);
    	
    	//Agregar la fideliazción
    	//FidelizacionModel fidelizacion = new FidelizacionModel();	

    	return pedido;
    }
}


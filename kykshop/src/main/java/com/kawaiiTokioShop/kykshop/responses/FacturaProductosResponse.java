package com.kawaiiTokioShop.kykshop.responses;

import java.util.List;

import com.kawaiiTokioShop.kykshop.models.FacturaModel;
import com.kawaiiTokioShop.kykshop.models.PedidoModel;
import com.kawaiiTokioShop.kykshop.models.ProductosFacturaModel;

public class FacturaProductosResponse {
	
	private PedidoModel pedido;
	private FacturaModel factura;
	private List<ProductosFacturaModel> productosFactura;
	
	public PedidoModel getPedido() {
		return pedido;
	}
	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}
	public FacturaModel getFactura() {
		return factura;
	}
	public void setFactura(FacturaModel factura) {
		this.factura = factura;
	}
	public List<ProductosFacturaModel> getProductosFactura() {
		return productosFactura;
	}
	public void setProductosFactura(List<ProductosFacturaModel> productosFactura) {
		this.productosFactura = productosFactura;
	}

}

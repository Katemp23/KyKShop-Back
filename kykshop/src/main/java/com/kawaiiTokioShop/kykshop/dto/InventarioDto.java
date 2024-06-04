package com.kawaiiTokioShop.kykshop.dto;

import com.kawaiiTokioShop.kykshop.models.InventarioModel;
import com.kawaiiTokioShop.kykshop.models.ProductoModel;

public class InventarioDto {
	
	InventarioModel inventario;
	ProductoModel producto;
	
	public InventarioModel getInventario() {
		return inventario;
	}
	public void setInventario(InventarioModel inventario) {
		this.inventario = inventario;
	}
	public ProductoModel getProducto() {
		return producto;
	}
	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

}

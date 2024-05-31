package com.kawaiiTokioShop.kykshop.convert;

import java.util.ArrayList;
import java.util.List;

import com.kawaiiTokioShop.kykshop.dto.ProductoDto;
import com.kawaiiTokioShop.kykshop.models.InventarioModel;
import com.kawaiiTokioShop.kykshop.models.ProductoModel;

public class ProductoConvert {

	public static ProductoDto convertToDto(ProductoModel producto, InventarioModel inventario) {
		ProductoDto dto = new ProductoDto();
        dto.setId(producto.getIdProducto());
        dto.setTitle(inventario.getArticulo());
        dto.setDescription(producto.getCaracteristicas());
        dto.setCategory(producto.getTipoArticulo());
        dto.setPrice(producto.getVlrUnitarioVenta());
        dto.setDiscountPercentage(producto.getDescuento());
        dto.setRating(producto.getRating());
        dto.setStock(inventario.getCantidad());
        dto.setBrand(producto.getMarca());
        List<String> images = new ArrayList<>();
        images.add(producto.getUrlImagen());
        dto.setImages(images);
        dto.setThumbnail(producto.getThumbnail());
        return dto;
    }

    public static List<ProductoDto> convertToDtoList(List<ProductoModel> productos, InventarioModel inventario) {
        List<ProductoDto> dtos = new ArrayList<>();
        for (ProductoModel producto : productos) {
            dtos.add(convertToDto(producto, inventario));
        }
        return dtos;
    }
}


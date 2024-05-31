package com.kawaiiTokioShop.kykshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Producto")
    private int idProducto;

    @Column(name = "id_Inventario")
    private int idInventario;

    @Column(name = "Tipo_Articulo")
    private String tipoArticulo;

    @Column(name = "Caracteristicas")
    private String caracteristicas;

    @Column(name = "Vlr_Unitario_Compra")
    private double vlrUnitarioCompra;

    @Column(name = "Vlr_Unitario_Venta")
    private Double vlrUnitarioVenta;

    @Column(name = "Precio_Puntos")
    private Integer precioPuntos;

    @Column(name = "id_Almacen")
    private int idAlmacen;

    @Column(name = "Rating")
    private Double rating;

    @Column(name = "Descuento")
    private Double descuento;

    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Column(name = "url_imagen")
    private String urlImagen;
    
    @Column(name = "Marca")
    private String marca;
    
    // Métodos getter y setter
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getVlrUnitarioCompra() {
        return vlrUnitarioCompra;
    }

    public void setVlrUnitarioCompra(double vlrUnitarioCompra) {
        this.vlrUnitarioCompra = vlrUnitarioCompra;
    }

    public Double getVlrUnitarioVenta() {
        return vlrUnitarioVenta;
    }

    public void setVlrUnitarioVenta(Double vlrUnitarioVenta) {
        this.vlrUnitarioVenta = vlrUnitarioVenta;
    }

    public Integer getPrecioPuntos() {
        return precioPuntos;
    }

    public void setPrecioPuntos(Integer precioPuntos) {
        this.precioPuntos = precioPuntos;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}


package com.kawaiiTokioShop.kykshop.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas")
public class FacturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Factura")
    private int idFactura;

    @Column(name = "Fecha_Factura")
    private LocalDateTime fechaFactura;

    @Column(name = "id_Persona")
    private int idPersona;

    @Column(name = "Estado_Factura")
    private String estadoFactura;

    @Column(name = "Cantidad_Vendida")
    private Integer cantidadVendida;

    @Column(name = "id_Pedido")
    private int idPedido;
    
    @Column(name = "Numero_tarjeta")
    private String NumeroTarjeta;
    
    @Column(name = "FV_tarjeta")
    private String FVTarjeta;
    
    @Column(name = "CVV_tarjeta")
    private String CVVTarjeta;
    
    @Column(name = "Vrl_total")
    private double vrlTotal;

    // Métodos getter y setter
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDateTime getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDateTime fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

	public String getNumeroTarjeta() {
		return NumeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		NumeroTarjeta = numeroTarjeta;
	}

	public String getFVTarjeta() {
		return FVTarjeta;
	}

	public void setFVTarjeta(String fVTarjeta) {
		FVTarjeta = fVTarjeta;
	}

	public String getCVVTarjeta() {
		return CVVTarjeta;
	}

	public void setCVVTarjeta(String cVVTarjeta) {
		CVVTarjeta = cVVTarjeta;
	}

	public double getVrlTotal() {
		return vrlTotal;
	}

	public void setVrlTotal(double vrlTotal) {
		this.vrlTotal = vrlTotal;
	}

}

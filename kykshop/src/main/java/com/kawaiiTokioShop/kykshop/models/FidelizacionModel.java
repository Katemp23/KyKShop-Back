package com.kawaiiTokioShop.kykshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fidelizacion")
public class FidelizacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Fidelizacion")
    private int idFidelizacion;

    @Column(name = "Puntos_Acumulados")
    private int puntosAcumulados;

    @Column(name = "Nivel")
    private int nivel;

    @Column(name = "Puntos_Canjeados")
    private int puntosCanjeados;

    @Column(name = "Rango_Descuentos")
    private double rangoDescuentos;

    @Column(name = "id_Factura")
    private int idFactura;

    // Métodos getter y setter
    public int getIdFidelizacion() {
        return idFidelizacion;
    }

    public void setIdFidelizacion(int idFidelizacion) {
        this.idFidelizacion = idFidelizacion;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosCanjeados() {
        return puntosCanjeados;
    }

    public void setPuntosCanjeados(int puntosCanjeados) {
        this.puntosCanjeados = puntosCanjeados;
    }

    public double getRangoDescuentos() {
        return rangoDescuentos;
    }

    public void setRangoDescuentos(double rangoDescuentos) {
        this.rangoDescuentos = rangoDescuentos;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
}


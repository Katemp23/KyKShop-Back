package com.kawaiiTokioShop.kykshop.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoIdentificacion {
	
    CC("CC", "Cédula de Ciudadania"),
    CE("CE", "Cédula de Extranjería"),
    TI("TI", "Tarjeta de Identidad"),
    PAS("PAS", "Pasaporte"),
    DNI("DNI", "DNI");

    private final String codigo;
    private final String descripcion;

    TipoIdentificacion(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}

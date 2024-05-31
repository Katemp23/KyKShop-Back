package com.kawaiiTokioShop.kykshop.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.PersonaModel;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaModel, Integer>{
	
	//TODO: Este método no es necesario, sólo es para mostrar como obtener datos por cualquier campo
	public abstract ArrayList<PersonaModel> findByNombres(String nombre);
	
	public abstract ArrayList<PersonaModel> findByIdentificacion(String identificacion);
	
	public abstract ArrayList<PersonaModel> findByCorreo(String correo);

}

package com.fabricaautomoviles.apirest.entity;

import java.util.ArrayList;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="automovil")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Automovil{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Type(type = "json")
	@Column (name="opcionales", columnDefinition = "json")
	private ArrayList<String> opcionales;
	
	@Column (name="costo_final")
	private double costo_final;	
	
	/*----------------------------------------*/
	/*--------- versiones disponibles --------*/
	private static final int SEDAN		= 230000;
	private static final int COUPE		= 275000;
	private static final int FAMILIAR	= 245000;
	
	/*-------- opcionales disponibles --------*/
	private static final int TC 	= 12000;
	private static final int AA 	= 20000;
	private static final int ABS 	= 14000;
	private static final int AB 	= 7000;
	private static final int LL 	= 12000;
	
	/*----------------------------------------*/
	
	
	public Automovil() {}
	
	public Automovil(int id, String nombre, ArrayList<String> opcionales, double costo_final) {
		this.id = id;
		this.nombre = nombre;
		this.opcionales = opcionales;
		this.costo_final = costo_final;
	}

	
	public void obtenerCosto() {
		
		double costo=0;
		
		if(nombre.equals("sedan"))
			costo+=SEDAN;
		if(nombre.equals("coupe"))
			costo+=COUPE;
		if(nombre.equals("familiar"))
			costo+=FAMILIAR;	
		
		int i=0;		
		while(i<opcionales.size()) {
			switch(opcionales.get(i)) {
				case "TC": 	costo+=TC;
							break;
				case "AA": 	costo+=AA;
							break;
				case "ABS": costo+=ABS;
							break;
				case "AB": 	costo+=AB;
							break;
				case "LL": 	costo+=LL;
							break;
				default:
			}
			i++;
		}	
		
		this.costo_final = costo;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getOpcionales() {
		return opcionales;
	}

	public void setOpcionales(ArrayList<String> opcionales) {
		this.opcionales = opcionales;
	}
	
	public double getCostoFinal() {
		return costo_final;
	}

	public void setCostoFinal(double costo_final) {
		this.costo_final = costo_final;
	}
		
	
	
	@Override
	public String toString() {
		return "Automovil [id=" + id + ", nombre=" + nombre + ", costo final=" + costo_final + ", opcionales=" + opcionales + "]";
	}	
	
	
}

package br.com.sparktest.sparkTest.model;

public class Carro {
	private int  id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	private String modelo;
	private String marca;
	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", marca=" + marca + "]";
	}
	
	

}

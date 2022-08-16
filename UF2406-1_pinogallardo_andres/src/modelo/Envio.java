package modelo;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Envio {
	private String ciudadOrigen;
	private boolean origenNacional;
	private String ciudadDestino;
	private boolean destinoNacional;
	private String tipoEnvio;
	private int peso;

	public Envio() {
		// TODO Esbozo de constructor generado automáticamente
	}

	public Envio(String ciudadOrigen, boolean origenNacional, String ciudadDestino, boolean destinoNacional,
			String tipoEnvio, int peso) {
		super();
		this.ciudadOrigen = ciudadOrigen;
		this.origenNacional = origenNacional;
		this.ciudadDestino = ciudadDestino;
		this.destinoNacional = destinoNacional;
		this.tipoEnvio = tipoEnvio;
		this.peso = peso;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public boolean isOrigenNacional() {
		return origenNacional;
	}

	public void setOrigenNacional(boolean origenNacional) {
		this.origenNacional = origenNacional;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public boolean isDestinoNacional() {
		return destinoNacional;
	}

	public void setDestinoNacional(boolean destinoNacional) {
		this.destinoNacional = destinoNacional;
	}

	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudadDestino, ciudadOrigen, destinoNacional, origenNacional, peso, tipoEnvio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Envio other = (Envio) obj;
		return Objects.equals(ciudadDestino, other.ciudadDestino) && Objects.equals(ciudadOrigen, other.ciudadOrigen)
				&& destinoNacional == other.destinoNacional && origenNacional == other.origenNacional
				&& peso == other.peso && Objects.equals(tipoEnvio, other.tipoEnvio);
	}
	
	
	public double calculaImporte() {
		
		
		double precio=0;
		if (origenNacional && destinoNacional) {
			precio = 4;
		} else {
			precio = 7;
		}
		if (tipoEnvio=="Paq 10 - Antes de las 10 h") {
			precio = precio + 5;
		} else if (tipoEnvio=="Paq 14 - Antes de las 14 h"){
			precio = precio + 2;
		} 
		
		if (peso >= 10 && peso < 20) {
			precio = precio + 3.5;
		}
		if (peso >= 20 && peso < 30) {
			precio = precio + 3.5*2;
		}
		if (peso >= 30 && peso <= 40) {
			precio = precio + 3.5*3;
		}
		
		return precio;
		
	}

	
	
	
}

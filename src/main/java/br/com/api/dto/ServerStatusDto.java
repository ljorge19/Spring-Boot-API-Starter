package br.com.api.dto;

public class ServerStatusDto {

	private String date;
	private Boolean liberado;
	private Boolean aviso;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Boolean getAviso() {
		return aviso;
	}

	public void setAviso(Boolean aviso) {
		this.aviso = aviso;
	}

}

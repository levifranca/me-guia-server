package edu.metrocamp.meguia.api.model;

public class RegistroIdentificacao {
	private Integer id;
	private Beacon beacon;
	private Long timestampMillis;
	private EstatisticaDia estatisticaDia;
	private EstatisticaHora estatisticaHora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	public Long getTimestampMillis() {
		return timestampMillis;
	}

	public void setTimestampMillis(Long timestampMillis) {
		this.timestampMillis = timestampMillis;
	}

	public EstatisticaDia getEstatisticaDia() {
		return estatisticaDia;
	}

	public void setEstatisticaDia(EstatisticaDia estatisticaDia) {
		this.estatisticaDia = estatisticaDia;
	}

	public EstatisticaHora getEstatisticaHora() {
		return estatisticaHora;
	}

	public void setEstatisticaHora(EstatisticaHora estatisticaHora) {
		this.estatisticaHora = estatisticaHora;
	}

}

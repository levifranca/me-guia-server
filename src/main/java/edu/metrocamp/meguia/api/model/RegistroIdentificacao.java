package edu.metrocamp.meguia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Registro_Identificacao")
public class RegistroIdentificacao {
	
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ID_Beacon")
	private Beacon beacon;
	
	@Column(name = "Timestamp_Millis")
	private Long timestampMillis;
	
	@ManyToOne
	@JoinColumn(name = "ID_Estatisticas_SUM_Dia")
	private EstatisticaDia estatisticaDia;
	
	@ManyToOne
	@JoinColumn(name = "ID_Estatisticas_SUM_Hora")
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

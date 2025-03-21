package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO
@Entity
@DiscriminatorValue("coach")
public class Coach extends Persona
{
	private double stipendio;
	private int anniEsperienza;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "coach")
	private List<Rendimento> rendimenti = new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_team")
	private Team team;


	public Coach() {}

	public Coach(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, double stipendio, int anniEsperienza)
	{
		super(id, nome, cognome, dob, cf, luogoDiNascita, genere);
		this.stipendio = stipendio;
		this.anniEsperienza = anniEsperienza;
	}

	public Coach(double stipendio, int anniEsperienza)
	{
		this.stipendio = stipendio;
		this.anniEsperienza = anniEsperienza;
	}

	public double getStipendio()
	{
		return stipendio;
	}

	public void setStipendio(double stipendio)
	{
		this.stipendio = stipendio;
	}

	public int getAnniEsperienza()
	{
		return anniEsperienza;
	}

	public void setAnniEsperienza(int anniEsperienza)
	{
		this.anniEsperienza = anniEsperienza;
	}
}

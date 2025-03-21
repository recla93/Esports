package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

//TODO
@Entity
@DiscriminatorValue("motivatore")
public class Motivatore extends Persona
{
	private double stipendio;
	private boolean psicologo;
	private int anniEsperienza;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_team")
	private Team team;

	public Motivatore(){}

	public Motivatore(double stipendio, int anniEsperienza, boolean psicologo)
	{
		this.stipendio = stipendio;
		this.anniEsperienza = anniEsperienza;
		this.psicologo = psicologo;
	}

	public Motivatore(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, double stipendio, boolean psicologo, int anniEsperienza)
	{
		super(id, nome, cognome, dob, cf, luogoDiNascita, genere);
		this.stipendio = stipendio;
		this.psicologo = psicologo;
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

	public boolean isPsicologo()
	{
		return psicologo;
	}

	public void setPsicologo(boolean psicologo)
	{
		this.psicologo = psicologo;
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

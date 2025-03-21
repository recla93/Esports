package model.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO
@Entity
@DiscriminatorValue("arbitro")
public class Arbitro extends Persona
{
	private double stipendio;
	private int anniLavoro;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "arbitro")
	List<Lobby> lobbies = new ArrayList<>();

	public Arbitro(){}

	public Arbitro(double stipendio, int anniLavoro)
	{
		this.stipendio = stipendio;
		this.anniLavoro = anniLavoro;
	}

	public Arbitro(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, double stipendio, int anniLavoro)
	{
		super(id, nome, cognome, dob, cf, luogoDiNascita, genere);
		this.stipendio = stipendio;
		this.anniLavoro = anniLavoro;
	}

	public double getStipendio()
	{
		return stipendio;
	}

	public void setStipendio(double stipendio)
	{
		this.stipendio = stipendio;
	}

	public int getAnniLavoro()
	{
		return anniLavoro;
	}

	public void setAnniLavoro(int anniLavoro)
	{
		this.anniLavoro = anniLavoro;
	}
}

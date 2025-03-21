package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
//TODO

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.STRING)
public abstract class Persona extends BaseEntity
{
	protected String nome,cognome;
	protected String genere;
	protected LocalDate dob;
	protected String cf;
	protected String luogoDiNascita;

	public Persona(){}

	public Persona(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita,String genere)
	{
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.cf = cf;
		this.luogoDiNascita = luogoDiNascita;
		this.genere = genere;
	}

	public Persona(String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita,String genere)
	{
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.cf = cf;
		this.luogoDiNascita = luogoDiNascita;
		this.genere = genere;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(LocalDate dob)
	{
		this.dob = dob;
	}

	public String getCf()
	{
		return cf;
	}

	public void setCf(String cf)
	{
		this.cf = cf;
	}

	public String getLuogoDiNascita()
	{
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita)
	{
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getGenere()
	{
		return genere;
	}

	public void setGenere(String genere)
	{
		this.genere = genere;
	}
}

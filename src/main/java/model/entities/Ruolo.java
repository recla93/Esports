package model.entities;
//TODO

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ruolo extends BaseEntity
{
	String ruolo;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "ruolo")
	private List<Player> players = new ArrayList<>();

	public Ruolo(){}

	public Ruolo(String ruolo)
	{
		this.ruolo = ruolo;
	}

	public Ruolo(Long id, String ruolo)
	{
		super(id);
		this.ruolo = ruolo;
	}

	public String getRuolo()
	{
		return ruolo;
	}

	public void setRuolo(String ruolo)
	{
		this.ruolo = ruolo;
	}
}

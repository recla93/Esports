package model.entities;

import jakarta.persistence.*;
//TODO

@Entity
@DiscriminatorValue("rendimento")
public class Rendimento extends BaseEntity
{
private String tipologia;
private int voto;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_player")
private Player player;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_coach")
private Coach coach;

	public Rendimento(){}

	public Rendimento(String tipologia, int voto)
	{
		this.tipologia = tipologia;
		this.voto = voto;
	}

	public Rendimento(Long id, String tipologia, int voto)
	{
		super(id);
		this.tipologia = tipologia;
		this.voto = voto;
	}

	public String getTipologia()
	{
		return tipologia;
	}

	public void setTipologia(String tipologia)
	{
		this.tipologia = tipologia;
	}

	public int getVoto()
	{
		return voto;
	}

	public void setVoto(int voto)
	{
		this.voto = voto;
	}
}

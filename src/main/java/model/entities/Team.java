package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

//TODO
@Entity
public class Team extends BaseEntity
{
	private int postiMax;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	List<Player> players = new ArrayList<>();

	@OneToOne(mappedBy = "team")
	private Motivatore motivatore;

	@OneToOne(mappedBy = "team")
	private Coach coach;

	public Team(){}

	public Team(int postiMax)
	{
		this.postiMax = postiMax;
	}

	public Team(Long id, int postiMax)
	{
		super(id);
		this.postiMax = postiMax;
	}

	public int getPostiMax()
	{
		return postiMax;
	}

	public void setPostiMax(int postiMax)
	{
		this.postiMax = postiMax;
	}
}

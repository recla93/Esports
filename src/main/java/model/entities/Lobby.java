package model.entities;
//TODO

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lobby extends BaseEntity
{
	private int postiMax;
	private boolean chatVocale;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lobby")
	List<Player> players = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_arbitro")
	private Arbitro arbitro;

	public Lobby(){}
	public Lobby(int postiMax, boolean chatVocale)
	{
		this.postiMax = postiMax;
		this.chatVocale = chatVocale;
	}

	public Lobby(Long id, int postiMax, boolean chatVocale)
	{
		super(id);
		this.postiMax = postiMax;
		this.chatVocale = chatVocale;
	}

	public int getPostiMax()
	{
		return postiMax;
	}

	public void setPostiMax(int postiMax)
	{
		this.postiMax = postiMax;
	}

	public boolean isChatVocale()
	{
		return chatVocale;
	}

	public void setChatVocale(boolean chatVocale)
	{
		this.chatVocale = chatVocale;
	}
}

package model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO
@Entity
@DiscriminatorValue("player")
public class Player extends Persona
{
	private String nickname;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
	private List<Rendimento> rendimenti = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_team")
	private Team team;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lobby")
	private Lobby lobby;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
			(
					name = "plauer_to_ruolo",
					joinColumns = @JoinColumn(name = "id_player"),
					inverseJoinColumns = @JoinColumn(name = "id_ruolo")
			)
	private List<Ruolo> ruolo = new ArrayList<>();


	public Player(){}

	public Player(String nickname)
	{
		this.nickname = nickname;
	}

	public Player(Long id, String nome, String cognome, LocalDate dob, String cf, String luogoDiNascita, String genere, String nickname)
	{
		super(id, nome, cognome, dob, cf, luogoDiNascita, genere);
		this.nickname = nickname;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

}

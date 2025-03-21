package model.entities;

import jakarta.persistence.*;
//TABLE per CLASS, metti i campi definiti qui nelle tabelle di chi ti eredita
@MappedSuperclass
public abstract class BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public BaseEntity()	{	}

	public BaseEntity(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
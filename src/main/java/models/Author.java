package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_author;
	@NotNull
	private String name;
	@NotNull
	private String sobrenome;
	
	@OneToMany(mappedBy = "author")
	private List<Note> notes;

	public Author() {
	}

	public Author(long id, String name, String sobrenome) {
		super();
		this.id_author = id;
		this.name = name;
		this.sobrenome = sobrenome;
	}

	public long getId() {
		return id_author;
	}

	public void setId(long id) {
		this.id_author = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_author ^ (id_author >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id_author != other.id_author)
			return false;
		return true;
	}
	
	
}

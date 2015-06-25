package models;

import java.io.Serializable;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class User implements Serializable {

	private static final long serialVersionUID = -241940758011784797L;
	private BasicDBObject _id;
	private String nome;
	private String email;
	private String senha;
	private String id;

	public DBObject bsonFromPojo() {
		BasicDBObject document = new BasicDBObject();

		document.put(" _id ", this._id);
		document.put(" nome ", this.nome);
		document.put(" email ", this.email);
		document.put(" senha ", this.senha);

		return document;
	}

	public BasicDBObject get_id() {
		return _id;
	}

	public void set_id(BasicDBObject _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

package models;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Book {

	private BasicBSONObject _id;
	private String isbn;
	private String ano;
	private String titulo;
	private String autor;
	private String editora;
	private String genero;
	private String observacao;
	private boolean lido;
	private String id;

	public DBObject bsonFromPojo() {
		
		BasicDBObject document = new BasicDBObject();
		document.put(" _id ", this._id);
		document.put("isbn", this.isbn);
		document.put("ano", this.ano);
		document.put("titulo", this.titulo);
		document.put("autor", this.autor);
		document.put("editora", this.editora);
		document.put("genero", this.genero);
		document.put("observacao", this.observacao);
		document.put("lido", this.lido);
		return document;
//		new MongoParser().toDBObject(this)
	}

	public void makePojoFromBson(DBObject bson) {
		BasicDBObject b = (BasicDBObject) bson;
		this._id = (BasicBSONObject) b.get("_id");
		this.isbn = (String) b.get("isbn");
		this.ano = (String) b.get("ano");
		this.titulo = (String) b.get("titulo");
		this.autor = (String) b.get("autor");
		this.editora = (String) b.get("editora");
		this.genero = (String) b.get("genero");
		this.observacao = (String) b.get("observacao");
		this.lido = (Boolean) b.get("lido");
	}

	public BasicBSONObject get_id() {
		return _id;
	}

	public void set_id(BasicBSONObject _id) {
		this._id = _id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isLido() {
		return lido;
	}

	public void setLido(boolean lido) {
		this.lido = lido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

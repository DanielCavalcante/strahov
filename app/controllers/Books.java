package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Book;

import org.bson.types.ObjectId;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import util.MongoInstance;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Books extends Controller {
	
	private static Form<Book> bookForm = Form.form(Book.class);
	private static DB db = MongoInstance.getInstance().getDB();
	private static DBCollection coll = db.getCollection("Livro");
	
	public static Result create() {
		return ok(views.html.book.create.render(bookForm));
	}
	
	public static Result list() {
		DBCursor cursor = coll.find();
		List<Book> books = new ArrayList<Book>();
		
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			ObjectId id = (ObjectId) obj.get("_id");
			Book book = new Gson().fromJson(obj.toString(), Book.class);
			book.setId(id.toString());
			books.add(book);
			
			DBObject o = book.bsonFromPojo();
			System.out.println(o.toString());
		}
		
		return ok(views.html.book.list.render(books));
	}
	
	public static Result save() {
		Form<Book> formFromRequest = bookForm.bindFromRequest();
		
		if (formFromRequest.hasErrors()) {
			flash("error", "Foram identificados problemas no cadastro");
			return badRequest(views.html.book.create.render(bookForm));
		}
		
		Book book = formFromRequest.get();
		BasicDBObject query = bind(book);
		
		if (book.get_id() == null && book.get_id().isEmpty()) {
			coll.insert(query);
			flash("sucess", "book salvo com sucesso");
		} else {
//			query.put("_id", new ObjectId(book.getId()));
//			DBObject o = coll.findOne(query);
//			coll.update(q, o);
		}
		
		return redirect(routes.Books.list());
	}
	
	public static Result edit(String objectId) {
		BasicDBObject o = new BasicDBObject("_id", new ObjectId(objectId));
		DBObject query = coll.findOne(o);
		Book book = new Gson().fromJson(query.toString(), Book.class);
		return ok(views.html.book.edit.render(book));
	}
	
	public static Result remove(String objectId) {
		if (objectId != null && !objectId.isEmpty()) {
			BasicDBObject deleteQuery = new BasicDBObject("_id", new ObjectId(objectId));
			DBObject query = coll.findOne(deleteQuery);
			coll.remove(query);
		}
		return redirect(routes.Books.list());
	}
	
	private static BasicDBObject bind(Book book) {
		BasicDBObject query = new BasicDBObject();
		query.put("isbn", book.getIsbn());
		query.put("ano", book.getAno());
		query.put("titulo", book.getTitulo());
		query.put("autor", book.getAutor());
		query.put("editora", book.getEditora());
		query.put("genero", book.getGenero());
		query.put("observacao", book.getObservacao());
		query.put("lido", book.isLido());
		
		return query;
	}
	
}

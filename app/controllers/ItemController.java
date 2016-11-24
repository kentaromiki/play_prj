package controllers;

import play.data.Form;

import play.libs.Json;
import play.*;

import play.mvc.*;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import play.data.validation.*;
import play.data.validation.Constraints.Validator;
import views.html.*;

import models.UserMaster;
import models.Item;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

import views.html.index;
import views.form.itemform;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class ItemController extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */

	public Result select(Long id) {
		Item item = Item.finder.byId(id);

		return ok(Json.toJson(item));

	}

	public Result selectAll() {

		List<Item> item = Item.finder.all();
		return ok(Json.toJson(item));

	}

	public Result insert() {
		// Item item = Item.finder.byId(id);
		// render(item);

		Item item = Json.fromJson(request().body().asJson(), Item.class);
		// item.title="axd";
		
		
		String error="";
		
		//abc(item,error);
		
		if(item.title == null) {
	        error+="Not Title ";
	        
	    } 
		else if(item.title.length()>=4){
	    	error+="Too longer Title ";
	    
	    }
	    if(item.detail == null) {
	        error+="Not detail ";
	        
	    } 
	    else if(item.detail.length()>=200){
	    	error+="Too longer detail ";
	    
	    }
	    if(error!=""){
	    	return badRequest(error);
	    	
//	        
	    }else{
	        item.save();
	        return ok("Hello " + item.title);
	        
	    }
		
		
		

		
	}

	public Result delete(Long id) {

		
		Item item = Item.finder.byId(id);
		item.delete();
		return ok("ok");
	}

	@SuppressWarnings("deprecation")

	public Result upload(Long id) {
		MultipartFormData<File> body = request().body().asMultipartFormData();
		FilePart<File> picture = body.getFile("picture");
		if (picture != null) {
			String fileName = picture.getFilename();
			String fileName2 = "sam (" + id + ").jpg";
			String contentType = picture.getContentType();
			File file = picture.getFile();

			String myUploadPath = "./public/images/";
			file.renameTo(new File(myUploadPath, fileName2));

			return ok("File uploaded " + fileName2);
		} else {
			flash("error", "Missing file");
			return ok("faild upload");
		}
	}

	public Result update(Long id) {
		// Item item = Item.finder.byId(id);
		// render(item);
		Item item = Item.finder.byId(id);
		Item newItem = Json.fromJson(request().body().asJson(), Item.class);
		// item.title="axd";
		item.title = newItem.title;
		item.detail = newItem.detail;
		item.money = newItem.money;

		item.save();

		return ok("ok");
	}

	public void abc(Item item,String error){
		
		
		if(item.title==null||item.title==""){
			error+="No title";
			
		}
		
	}
}

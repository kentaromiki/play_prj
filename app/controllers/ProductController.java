package controllers;

import play.data.Form;
import play.libs.Json;
import play.*;


import play.mvc.*;

import java.io.File;
import java.util.List;
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
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ProductController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
   
	public Result select(Long id)  {
	    Item item = Item.finder.byId(id);
	    //render(item);
		//List<Item> item = Item.finder.all();
	    return ok(Json.toJson(item));
		
	}
	
	public Result selectAll()  {
	   
	    //render(item);
		List<Item> item = Item.finder.all();
	    return ok(Json.toJson(item));
		
	}
	
	

	public Result insert()  {
	    //Item item = Item.finder.byId(id);
	    //render(item);
		
		 Item item=Json.fromJson(request().body().asJson(), Item.class);
		 //item.title="axd";
		 
	       item.save();
	       
	     
		return ok("ok");
	}
	
	public Result delete(Long id)  {
		
		 Item item = Item.finder.byId(id);
	     item.delete();
		return ok("ok");
	}
	
	public Result upload()  {
		
		
		return ok("ok");
	}
	
	public Result update(Long id)  {
	    //Item item = Item.finder.byId(id);
	    //render(item);
		Item item= Item.finder.byId(id);
		 Item newItem=Json.fromJson(request().body().asJson(), Item.class);
		 //item.title="axd";
		 item.title=newItem.title;
		 item.detail=newItem.detail;
		 item.money=newItem.money;
		 
	       item.save();
	       
	     
		
		
	   
		return ok("ok");
	}
	
 


}

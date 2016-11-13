package controllers;

import play.data.Form;
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
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
    	
    	// ユーザーマスタを検索する
    			List<UserMaster> userMasterList = UserMaster.getFind().all();
    			for (UserMaster data : userMasterList) {
    				// 利用者名を出力する
    				System.out.println(data.getUserName());
    			}
    	
        return ok(index.render("Your new application is ready."));
    }
    
 public Result create() {
    	
    	// ユーザーマスタを検索する
	  itemform form = new itemform();
	    Form<itemform> formData = Form.form(itemform.class).fill(form);
	    Item item =  new Item();
	    
	    return ok(create.render("save", formData,item));
        
    }
 
 public Result top() {
 	
 	// ユーザーマスタを検索する
	  
	    
	    List<Item> item = Item.finder.all();
	    return ok(top.render("Actor List", item));
     
 }
 
 public Result detail(Long id) {
	    
	    Item item =  Item.finder.byId(id);
	    return ok(detail.render("Actor Detail", item));
	  }
 
 public Result edit(Long id) {
	    
	    itemform form = new itemform();
	    Form<itemform> formData = Form.form(itemform.class).fill(form);
	    Item item =  Item.finder.byId(id);
	    return ok(create.render("update",formData, item));
	  }
 
 public Result save() {
	  
	    Form<itemform> formData = Form.form(itemform.class).bindFromRequest();
	    
	    Item item = Item.convertToModel(formData.get());
		  
	  
	  
	      //item.update();
	       item.save();
	     
	    
	    return redirect("/top");
	  }
 
 public Result update() {
	  
	 
	    Form<itemform> formData = Form.form(itemform.class).bindFromRequest();
	    
	   
	  
	    Long id=  Long.parseLong(formData.get().id);
	    
	    
	    Item item =  Item.finder.byId(id);
	      item.title=formData.get().title;
	      item.detail=formData.get().detail;
	      
	      
	      item.money=formData.get().money;
		  
	  
	      //item.update();
	       item.save();
	     
	    
	    return redirect("/top");
	  }
 
 public Result delete(Long id) {
	    
	 Item item = Item.finder.byId(id);
     item.delete();
	    
	    return redirect("/top");
	  }
 
 
 @SuppressWarnings("deprecation")
public Result upload() {
	 MultipartFormData<File> body = request().body().asMultipartFormData();
	    FilePart<File> picture = body.getFile("picture");
	    if (picture != null) {
	    	String fileName = picture.getFilename();
	        String contentType = picture.getContentType();
	        File file = picture.getFile();
	        
	     
	      return ok("File uploaded"+file);
	    } else {
	      flash("error", "Missing file");
	      return redirect("/top");
	    }
	  }
 

 


}

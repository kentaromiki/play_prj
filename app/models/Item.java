package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;


import views.form.itemform;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Required;



@Entity(name = "item")
public class Item extends Model {


  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  //@NotNull(message="必須入力です")
  //@Size(min = 1, max = 4 ,message="必須入力です")
  public String title;
  
  //@NotNull
  //@Size(min = 1, max = 300)
  public String detail;
  
  //@NotNull
  //@Size(min = 1, max = 20)
  public Integer money;
  
 
  public String image_url;

  

  public Item() {
  }

  public Item (Long id, String title, String detail,
      Integer money ,String imageUrl) {
    this.id = id;
    this.title = title;
    this.detail= detail;
    this.money = money;
    this.image_url = imageUrl;
  }


  public static Find<Long, Item> finder = new Find<Long, Item>(){};
  
  public static Item convertToModel(itemform form) {
	    Item item = new Item();
	    item.id = StringUtils.isNotEmpty(form.id) ? Long.valueOf(form.id) : null;
	    item.title = form.title;
	    
	    return item;
	  }

  
  @Override
  public String toString() {
    return "Item [id=" + id + ", title=" + title + ", detail=" + detail
        + ", money=" + money + ", imageUrl=" + image_url + "]";
  }


}

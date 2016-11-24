package views.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import play.api.data.validation.ValidationError;
import play.i18n.Messages;

public class itemform {

  public String id = "";
  public String name = "";
  public String title = "";
  public String detail = "";
  public Integer money = 0;
  public String imageUrl = "";

  public itemform() {
  }

  public itemform(String id, String name, String title, String detail,
      Integer money, String imageUrl) {
    this.id = id;
    this.name = name;
    this.title = title;
    this.detail = detail;
    this.money = money;
    this.imageUrl = imageUrl;
  }

  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<ValidationError>();

    
//    
//    if (title == null || title.length() == 0) {
//      errors.add(new ValidationError("title", "not title" ));
//    }
//    if (StringUtils.isNotEmpty(title)) {
//      Integer tmpH = Integer.valueOf(title);
//      if (tmpH < 1 && tmpH > 200) {
//        errors.add(new ValidationError("title", Messages.get("actor.title.range", 1, 200)));
//        
//      }
//    }
//    if (StringUtils.isNotEmpty(detail) && !detail.matches("A|B|AB|O")) {
//      errors.add(new ValidationError("detail", Messages.get("actor.detail.kind")));
//    }
//    if (StringUtils.isNotEmpty(money) && !money.matches("\\d{4}-\\d{2}-\\d{2}")) {
//      errors.add(new ValidationError("money", Messages.get("actor.money.pattern")));
//    }
//    if (StringUtils.isNotEmpty(imageUrl)) {
//      Integer tmpB = Integer.valueOf(imageUrl);
//      if (tmpB < 1 && tmpB > 47) {
//        errors.add(new ValidationError("imageUrl", Messages.get("actor.birthplace.range")));
//      }
//    }
//
//    if(errors.size() > 0) {
//      System.out.println("ActorForm#validate errors");
//      return errors;
//    }

    return errors;
  }

  @Override
  public String toString() {
    return "ActorForm [id=" + id + ", name=" + name + ", title=" + title
        + ", detail=" + detail + ", money=" + money + ", imageUrl="
        + imageUrl + "]";
  }

}

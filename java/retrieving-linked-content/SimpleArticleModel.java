// DocSection: linked_content_simple_article_model
// Create strongly typed models according to https://developer.kenticocloud.com/docs/strongly-typed-models

import com.kenticocloud.delivery.ContentItemMapping;
import com.kenticocloud.delivery.ElementMapping;
import com.kenticocloud.delivery.System;
import java.lang.String;
import java.util.List;

@ContentItemMapping("simple_article")
public class Homepage {
    @ElementMapping("title")
    String title;

    @ElementMapping("body")
    String body;
    
   	@ContentItemMapping("author")
  	List<ContentItem> author;

    System system;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
  
    public List<ContentItem> getAuthor() {
        return author;
    }

    public void setAuthor(List<ContentItem> author) {
        this.author = author;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }
}
// EndDocSection
package models;

import play.data.*;
import models.*;
import play.mvc.Result;
import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;
import play.data.*;
import static play.data.Form.*;

@SuppressWarnings("serial")
@Entity 
public class Task extends Model implements Comparable<Object> {
    
  @Id  
  public Long id;
  //@Required
  public String label;
  public String registrar;
  private boolean realizada = false;
  //@Required
  public int prioridade;
  //@Required
  public String projeto;
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
    
    public Long getId() {
		return id;
	}
	
	public boolean tarefarealizada() {
		return realizada;
	}

	public void settarefarealizada(boolean realizada) {
		this.realizada = realizada;
	}

	public String getRegistrar() {
		return registrar;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public String getProjeto() {
		return projeto;
	}
	
	public static List<Task> all() {
		return find.all();
	}
	
	public static void create(Task task) {
		task.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	public static void update(Long id) {
		Task task = find.ref(id);
        if (task.tarefarealizada() == true) {
        	task.settarefarealizada(false);
        } else{
        	task.settarefarealizada(true);
        }
        task.update();
	}

	@Override
	public int compareTo(Object arg0) {
		int result;
		if (prioridade == ((Task)arg0).prioridade) {
			result = 0;
		} else if (prioridade >= ((Task)arg0).prioridade) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}  
 
}

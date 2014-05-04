/**
 * 
 */
package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author francoisgrogor
 */
@Entity
@NamedQuery(name = "Category.getAllCategoriesWithItemsInitialised",
query = "SELECT c FROM Category c JOIN FETCH c.items i")
public class Category {
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String name;
	
	public String description;
	
	@ManyToOne(optional=true)
	public Category parentCategory;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="category")
	public List<Item> items;
	
	@Override
	public boolean equals(Object obj){
		
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Category category = (Category) obj;
        
        return new EqualsBuilder()
                      .appendSuper(super.equals(obj))
                      .append(name, category.name)
                      .append(description, category.description)
                      .append(parentCategory, category.parentCategory)
                      .isEquals();        
		
	}
	
	@Override
    public int hashCode() {
		return new HashCodeBuilder(19, 37).
			       append(name).
			       append(description).
			       append(parentCategory).
			       toHashCode();
    }

}

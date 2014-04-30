/**
 * 
 */
package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author francoisgrogor
 */
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String name;
	
	public String description;
	
	@ManyToOne(optional=true)
	public Category parentCategory;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
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

/**
 * 
 */
package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author francoisgrogor
 */
@Entity
public class ThirdParty {
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String name;
	
	public String description;
	
	@Override
	public boolean equals(Object obj){
		
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        ThirdParty thirdParty = (ThirdParty) obj;
        
        return new EqualsBuilder()
                      .appendSuper(super.equals(obj))
                      .append(name, thirdParty.name)
                      .append(description, thirdParty.description)
                      .isEquals();        
		
	}
	
	@Override
    public int hashCode() {
		return new HashCodeBuilder(19, 37).
			       append(name).
			       append(description).
			       toHashCode();
    }
	
}

package models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedQuery(name = "Items.findItemsForCategory",
query = "SELECT i FROM Item i INNER JOIN i.category c WHERE c.id = :categoryId")
public class Item {
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String name;
	
	public String description;
	
	@Column(unique=true)
	public String externalReference;
	
	public BigDecimal price;
	
	@OneToOne
	public Photo smallImage;

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="CATEGORY_ID")
	public Category category;

	@Override
	public boolean equals(Object obj){
		
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Item item = (Item) obj;

        return new EqualsBuilder()
        .appendSuper(super.equals(obj))
        .append(name, item.name)
        .append(description, item.description)
        .append(price, item.price)
        .append(category, item.category)
        .isEquals();     
		
	}
	
	@Override
    public int hashCode() {
		return new HashCodeBuilder(17, 37).
			       append(name).
			       append(description).
			       append(price).
			       append(category).
			       toHashCode();
    }

}

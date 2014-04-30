/**
 * 
 */
package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author francoisgrogor
 */
@Entity
public class Photo {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(length=65534)
	public byte [] image;

}

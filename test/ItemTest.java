import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;

import models.Category;
import models.Item;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import configs.AppConfig;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class ItemTest extends AbstractTransactionalJUnit4SpringContextTests {
 
    @Test
    public void setItemAttributes() {
        Category category = new Category();
        category.name = "Bread";
        category.description = "Brown Bread";
        assertThat(category.name).isEqualTo("Bread");
        assertThat(category.description).isEqualTo("Brown Bread");
        
        Item item = new Item();
        item.name = "Albs Brown Bread";
        item.description = "Albs Brown Bread";
        item.externalReference = "xxxx04";
        item.price = BigDecimal.TEN;
        item.category = category;
        
        assertThat(item.name).isEqualTo("Albs Brown Bread");
        assertThat(item.description).isEqualTo("Albs Brown Bread");
        assertThat(item.externalReference).isEqualTo("xxxx04");
        assertThat(item.price).isEqualTo(BigDecimal.TEN);
        assertThat(item.category).isEqualTo(category);
    }

}

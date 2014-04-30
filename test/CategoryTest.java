import static org.fest.assertions.Assertions.assertThat;
import models.Category;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import configs.AppConfig;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class CategoryTest extends AbstractTransactionalJUnit4SpringContextTests {
 
    @Test
    public void setCategoryAttributes() {
        Category category = new Category();
        category.name = "Bread";
        category.description = "Brown Bread";
        assertThat(category.name).isEqualTo("Bread");
        assertThat(category.description).isEqualTo("Brown Bread");
    }

}

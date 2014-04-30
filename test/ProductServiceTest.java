import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.List;

import models.Category;
import models.Item;
import models.ThirdParty;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import services.ProductService;
import configs.AppConfig;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class ProductServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ProductService productService;

    @Test
    public void createAndFindCategory() {
    	
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Category
		Category breadCategory = new Category();
		breadCategory.name = "Groceries";
		breadCategory.description = "Groceries";
		breadCategory.parentCategory = bakeryCategory;
		
		productService.createCategory(breadCategory);	
		breadCategory = productService.getCategory(breadCategory.id);
		
		assertNotNull(breadCategory);
		assertEquals(bakeryCategory,breadCategory.parentCategory);
		
		//Category
		Category brownBreadCategory = new Category();
		brownBreadCategory.name = "Groceries";
		brownBreadCategory.description = "Groceries";
		brownBreadCategory.parentCategory = breadCategory;
		
		productService.createCategory(brownBreadCategory);	
		brownBreadCategory = productService.getCategory(brownBreadCategory.id);
		
		assertNotNull(brownBreadCategory);
		assertEquals(breadCategory,brownBreadCategory.parentCategory);

    }
    
    @Test
    public void findAllCategoriesTest(){
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Category
		Category breadCategory = new Category();
		breadCategory.name = "Groceries";
		breadCategory.description = "Groceries";
		breadCategory.parentCategory = bakeryCategory;
		
		productService.createCategory(breadCategory);	
		breadCategory = productService.getCategory(breadCategory.id);
		
		assertNotNull(breadCategory);
		assertEquals(bakeryCategory,breadCategory.parentCategory);
		
		//Category
		Category brownBreadCategory = new Category();
		brownBreadCategory.name = "Groceries";
		brownBreadCategory.description = "Groceries";
		brownBreadCategory.parentCategory = breadCategory;
		
		productService.createCategory(brownBreadCategory);	
		brownBreadCategory = productService.getCategory(brownBreadCategory.id);
		
		assertNotNull(brownBreadCategory);
		assertEquals(breadCategory,brownBreadCategory.parentCategory);
		
		List<Category> allCategoires = productService.findAllCategories();
		assertNotNull(allCategoires);
		assertEquals(4, allCategoires.size());
    }
    
    @Test
    public void createAndFindItemTest(){
    	
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Item
		Item blueRibbonPremierOneBrownBread = new Item();
		blueRibbonPremierOneBrownBread.name = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.description = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.price = BigDecimal.TEN;
		blueRibbonPremierOneBrownBread.externalReference = "xxx02";
		blueRibbonPremierOneBrownBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneBrownBread);
		blueRibbonPremierOneBrownBread = productService.getItem(blueRibbonPremierOneBrownBread.id);
		
		assertNotNull(blueRibbonPremierOneBrownBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneBrownBread.category);

    }
    
    @Test
    public void findAllItemsTest(){
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Item
		Item blueRibbonPremierOneBrownBread = new Item();
		blueRibbonPremierOneBrownBread.name = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.description = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.price = BigDecimal.TEN;
		blueRibbonPremierOneBrownBread.externalReference = "xxx02";
		blueRibbonPremierOneBrownBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneBrownBread);
		blueRibbonPremierOneBrownBread = productService.getItem(blueRibbonPremierOneBrownBread.id);
		
		assertNotNull(blueRibbonPremierOneBrownBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneBrownBread.category);
		
		//Item2
		Item blueRibbonPremierOneWhiteBread = new Item();
		blueRibbonPremierOneWhiteBread.name = "Blue Ribbon Premier One White Bread";
		blueRibbonPremierOneWhiteBread.description = "Blue Ribbon Premier One White Bread";
		blueRibbonPremierOneWhiteBread.price = BigDecimal.TEN;
		blueRibbonPremierOneWhiteBread.externalReference = "xxx02";
		blueRibbonPremierOneWhiteBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneWhiteBread);
		blueRibbonPremierOneWhiteBread = productService.getItem(blueRibbonPremierOneWhiteBread.id);
		
		assertNotNull(blueRibbonPremierOneWhiteBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneWhiteBread.category);
		
		List<Item> allItems = productService.findAllItems();
		assertNotNull(allItems);
		assertEquals(2, allItems.size());
    }
    
    @Test
    public void testFindItemsForCategory(){
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Item
		Item blueRibbonPremierOneBrownBread = new Item();
		blueRibbonPremierOneBrownBread.name = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.description = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.price = BigDecimal.TEN;
		blueRibbonPremierOneBrownBread.externalReference = "xxx02";
		blueRibbonPremierOneBrownBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneBrownBread);
		blueRibbonPremierOneBrownBread = productService.getItem(blueRibbonPremierOneBrownBread.id);
		
		assertNotNull(blueRibbonPremierOneBrownBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneBrownBread.category);
		
		//Item2
		Item blueRibbonPremierOneWhiteBread = new Item();
		blueRibbonPremierOneWhiteBread.name = "Blue Ribbon Premier One White Bread";
		blueRibbonPremierOneWhiteBread.description = "Blue Ribbon Premier One White Bread";
		blueRibbonPremierOneWhiteBread.price = BigDecimal.TEN;
		blueRibbonPremierOneWhiteBread.externalReference = "xxx02";
		blueRibbonPremierOneWhiteBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneWhiteBread);
		blueRibbonPremierOneWhiteBread = productService.getItem(blueRibbonPremierOneWhiteBread.id);
		
		assertNotNull(blueRibbonPremierOneWhiteBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneWhiteBread.category);
		
		List<Item> itemsForCategory = productService.findItemsForCategory(bakeryCategory.id);
		assertEquals(2, itemsForCategory.size());
		
    }
    
    @Test
    public void findItemByExternalReference(){
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Item
		Item blueRibbonPremierOneBrownBread = new Item();
		blueRibbonPremierOneBrownBread.name = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.description = "Blue Ribbon Premier One Brown Bread";
		blueRibbonPremierOneBrownBread.price = BigDecimal.TEN;
		blueRibbonPremierOneBrownBread.externalReference = "xxx01";
		blueRibbonPremierOneBrownBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneBrownBread);
		blueRibbonPremierOneBrownBread = productService.getItem(blueRibbonPremierOneBrownBread.id);
		
		assertNotNull(blueRibbonPremierOneBrownBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneBrownBread.category);
		
		//Item2
		Item blueRibbonPremierOneWhiteBread = new Item();
		blueRibbonPremierOneWhiteBread.name = "Blue Ribbon Premier One White Bread";
		blueRibbonPremierOneWhiteBread.description = "Blue Ribbon Premier One White Bread";
		blueRibbonPremierOneWhiteBread.price = BigDecimal.TEN;
		blueRibbonPremierOneWhiteBread.externalReference = "xxx02";
		blueRibbonPremierOneWhiteBread.category = bakeryCategory;

		productService.createItem(blueRibbonPremierOneWhiteBread);
		blueRibbonPremierOneWhiteBread = productService.getItem(blueRibbonPremierOneWhiteBread.id);
		
		assertNotNull(blueRibbonPremierOneWhiteBread.id);
		assertEquals(bakeryCategory, blueRibbonPremierOneWhiteBread.category);
		
		Item itemWithExernalReference = productService.getItemWithExternalReference("xxx01");
		assertNotNull(itemWithExernalReference);
		assertEquals(blueRibbonPremierOneBrownBread, itemWithExernalReference);
		
		itemWithExernalReference = productService.getItemWithExternalReference("xxx02");
		assertNotNull(itemWithExernalReference);
		assertEquals(blueRibbonPremierOneWhiteBread, itemWithExernalReference);
    }

    @Test
    public void findSubCategoriesForCategory(){
    	//Category
    	Category groceryCategory = new Category();
		groceryCategory.name = "Groceries";
		groceryCategory.description = "Groceries";

		productService.createCategory(groceryCategory);	
		groceryCategory = productService.getCategory(groceryCategory.id);
		
		assertNotNull(groceryCategory);
		assertNull(groceryCategory.parentCategory);
		
		//Category
		Category bakeryCategory = new Category();
		bakeryCategory.name = "Groceries";
		bakeryCategory.description = "Groceries";
		bakeryCategory.parentCategory = groceryCategory;
		
		productService.createCategory(bakeryCategory);	
		bakeryCategory = productService.getCategory(bakeryCategory.id);
		
		assertNotNull(bakeryCategory);
		assertEquals(groceryCategory,bakeryCategory.parentCategory);
		
		//Category
		Category breadCategory = new Category();
		breadCategory.name = "Groceries";
		breadCategory.description = "Groceries";
		breadCategory.parentCategory = groceryCategory;
		
		productService.createCategory(breadCategory);	
		breadCategory = productService.getCategory(breadCategory.id);
		
		assertNotNull(breadCategory);
		assertEquals(groceryCategory,breadCategory.parentCategory);
		
		//Category
		Category brownBreadCategory = new Category();
		brownBreadCategory.name = "Groceries";
		brownBreadCategory.description = "Groceries";
		brownBreadCategory.parentCategory = groceryCategory;
		
		productService.createCategory(brownBreadCategory);	
		brownBreadCategory = productService.getCategory(brownBreadCategory.id);
		
		assertNotNull(brownBreadCategory);
		assertEquals(groceryCategory,brownBreadCategory.parentCategory);
		
		List<Category> subCategories = productService.findSubCategoriesForCategory(groceryCategory);
		assertNotNull(subCategories);
		assertEquals(3, subCategories.size());
    }
    
    @Test
    public void createAndFindThirPartyTest(){
		//ThirdParty
		ThirdParty thirdParty = new ThirdParty();
		thirdParty.name = "Pnp";
		thirdParty.description = "Pick n Pay";
		
		productService.createThirdParty(thirdParty);
		thirdParty = productService.getThirdParty(thirdParty.id);
		
		assertNotNull(thirdParty);
    }
    
}
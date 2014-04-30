package services;

import java.util.List;

import models.Category;
import models.Item;
import models.ThirdParty;

public interface ProductService {

    public void createItem(Item item);
    
    public List<Item> findAllItems();
    
    public Item getItem(Long id);
    
    public Item getItemWithExternalReference(String externalReference);
    
    public List<Item> findItemsForCategory(Long categoryId);
    
    public void createCategory(Category category);

    public List<Category> findAllCategories();
    
    public Category getCategory(Long id);
    
    public List<Category> findSubCategoriesForCategory(Category category);
    
    public void createThirdParty(ThirdParty thirdParty);
    
    public List<ThirdParty> findAllThirdParties();
    
    public ThirdParty getThirdParty(Long id);
    
    public List<Category> findCategoriesForThirdParty();
    
    
}
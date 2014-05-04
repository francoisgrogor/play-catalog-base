package controllers;

import java.util.List;

import models.Category;
import models.Item;
import models.ProductCatalogue;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.ProductService;
import views.html.index;;

@org.springframework.stereotype.Controller
public class Application {

    @Autowired
    private ProductService productService;

    public Result index() {
        return play.mvc.Controller.ok(index.render(Form.form(Category.class)));
    }

    public Result createItem(Long categoryId) {
        Form<Item> form = Form.form(Item.class).bindFromRequest();
        Item item = form.get();
        Category category = productService.getCategory(categoryId);
        item.category = category;
        productService.createItem(item);
        return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }
    
    public Result getItem(Long id) {
        return play.mvc.Controller.ok(Json.toJson(productService.getItem(id)));
    }
    
    public Result getItemWithExternalReference(String externalReference) {
        return play.mvc.Controller.ok(Json.toJson(productService.getItemWithExternalReference(externalReference)));
    }
    
    public Result findItemsForCategory(Long categoryId) {
        return play.mvc.Controller.ok(Json.toJson(productService.findItemsForCategory(categoryId)));
    }

    public Result findAllItems() {
        return play.mvc.Controller.ok(Json.toJson(productService.findAllItems()));
    }
    
    public Result createCategory() {
        Form<Category> form = Form.form(Category.class).bindFromRequest();
        Category category = form.get();
        productService.createCategory(category);
        return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }
    
    public Result createCategoryWithParentCategory(Long parentCategoryId) {
        Form<Category> form = Form.form(Category.class).bindFromRequest();
        Category category = form.get();
        Category parentCategory = productService.getCategory(parentCategoryId);
        category.parentCategory = parentCategory;
        productService.createCategory(category);
        return play.mvc.Controller.redirect(controllers.routes.Application.index());
    }

    public Result getCategory(Long id) {
        return play.mvc.Controller.ok(Json.toJson(productService.getCategory(id)));
    }
    
    public Result findAllCategories() {
        return play.mvc.Controller.ok(Json.toJson(productService.findAllItems()));
    }
    
    public Result findSubCategoriesForCategory(Long id){
    	return play.mvc.Controller.ok(Json.toJson(productService.findSubCategoriesForCategory(productService.getCategory(id))));
    }
    
    /**
     * @return entire product catalog in JSON format
     */
    public Result getProductJson(){
    	List<Category> categories = productService.findAllCategoriesWithItemsInitialised();
    	ProductCatalogue productCatalogue = new ProductCatalogue();
    	productCatalogue.setCategories(categories);
    	return play.mvc.Controller.ok(Json.toJson(productCatalogue));
    }
    
}
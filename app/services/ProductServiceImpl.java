package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.Category;
import models.Item;
import models.ThirdParty;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
	private
    EntityManager em;

    @Override
    public void createItem(Item item) {
        getEm().persist(item);
    }

    @Override
    public List<Item> findAllItems() {
        CriteriaQuery<Item> c = getEm().getCriteriaBuilder().createQuery(Item.class);
        c.from(Item.class);
        return getEm().createQuery(c).getResultList();
    }
    
    
    @Override
    public void createCategory(Category category) {
        getEm().persist(category);
    }

    @Override
    public List<Category> findAllCategories() {
        CriteriaQuery<Category> c = getEm().getCriteriaBuilder().createQuery(Category.class);
        c.from(Category.class);
        return getEm().createQuery(c).getResultList();
    }

	@Override
	public Item getItem(Long id) {
		return getEm().find(Item.class, id);
	}

	@Override
	public Category getCategory(Long id) {
		return getEm().find(Category.class, id);
	}

	@Override
	public void createThirdParty(ThirdParty thirdParty) {
		getEm().persist(thirdParty);
	}

	@Override
	public List<ThirdParty> findAllThirdParties() {
        CriteriaQuery<ThirdParty> c = getEm().getCriteriaBuilder().createQuery(ThirdParty.class);
        c.from(ThirdParty.class);
        return getEm().createQuery(c).getResultList();
	}

	@Override
	public ThirdParty getThirdParty(Long id) {
		return getEm().find(ThirdParty.class, id);
	}

	@Override
	public List<Item> findItemsForCategory(Long categoryId) {		
		TypedQuery<Item> query = getEm().createNamedQuery("Items.findItemsForCategory", Item.class);
		query.setParameter("categoryId", categoryId);
	    return query.getResultList();	
	}

	@Override
	public List<Category> findSubCategoriesForCategory(Category category) {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> categoryRoot = cq.from(Category.class);
        Predicate predicate = cb.equal(categoryRoot.get("parentCategory"), category);
        cq.where(predicate);
        cq.select(categoryRoot);
        TypedQuery<Category> tq = getEm().createQuery(cq);
        return tq.getResultList();
	}

	@Override
	public List<Category> findCategoriesForThirdParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemWithExternalReference(String externalReference) {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> itemRoot = cq.from(Item.class);
        Predicate predicate = cb.equal(itemRoot.get("externalReference"), externalReference);
        cq.where(predicate);
        cq.select(itemRoot);
        TypedQuery<Item> tq = getEm().createQuery(cq);
        return tq.getSingleResult();
	}

	@Override
	public List<Category> findAllCategoriesWithItemsInitialised() {		
		TypedQuery<Category> query = getEm().createNamedQuery("Category.getAllCategoriesWithItemsInitialised", Category.class);
	    return query.getResultList();	
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
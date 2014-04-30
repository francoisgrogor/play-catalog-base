package services;


import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.criteria.Predicate.BooleanOperator;

import models.Category;
import models.Item;
import models.ThirdParty;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createItem(Item item) {
        em.persist(item);
    }

    @Override
    public List<Item> findAllItems() {
        CriteriaQuery<Item> c = em.getCriteriaBuilder().createQuery(Item.class);
        c.from(Item.class);
        return em.createQuery(c).getResultList();
    }
    
    
    @Override
    public void createCategory(Category category) {
        em.persist(category);
    }

    @Override
    public List<Category> findAllCategories() {
        CriteriaQuery<Category> c = em.getCriteriaBuilder().createQuery(Category.class);
        c.from(Category.class);
        return em.createQuery(c).getResultList();
    }

	@Override
	public Item getItem(Long id) {
		return em.find(Item.class, id);
	}

	@Override
	public Category getCategory(Long id) {
		return em.find(Category.class, id);
	}

	@Override
	public void createThirdParty(ThirdParty thirdParty) {
		em.persist(thirdParty);
	}

	@Override
	public List<ThirdParty> findAllThirdParties() {
        CriteriaQuery<ThirdParty> c = em.getCriteriaBuilder().createQuery(ThirdParty.class);
        c.from(ThirdParty.class);
        return em.createQuery(c).getResultList();
	}

	@Override
	public ThirdParty getThirdParty(Long id) {
		return em.find(ThirdParty.class, id);
	}

	@Override
	public List<Item> findItemsForCategory(Long categoryId) {		
		TypedQuery<Item> query = em.createNamedQuery("Items.findItemsForCategory", Item.class);
		query.setParameter("categoryId", categoryId);
	    return query.getResultList();	
	}

	@Override
	public List<Category> findSubCategoriesForCategory(Category category) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> categoryRoot = cq.from(Category.class);
        Predicate predicate = cb.equal(categoryRoot.get("parentCategory"), category);
        cq.where(predicate);
        cq.select(categoryRoot);
        TypedQuery<Category> tq = em.createQuery(cq);
        return tq.getResultList();
	}

	@Override
	public List<Category> findCategoriesForThirdParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemWithExternalReference(String externalReference) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> itemRoot = cq.from(Item.class);
        Predicate predicate = cb.equal(itemRoot.get("externalReference"), externalReference);
        cq.where(predicate);
        cq.select(itemRoot);
        TypedQuery<Item> tq = em.createQuery(cq);
        return tq.getSingleResult();
	}

}
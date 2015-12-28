package br.com.fiap.pizzaria.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public class GenericDAOImpl<PK, T>  {
	
	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;
	
	
	/* (non-Javadoc)
	 * @see br.com.fiap.pizzaria.dao.GenericDAO#getById(PK)
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
	/* (non-Javadoc)
	 * @see br.com.fiap.pizzaria.dao.GenericDAO#save(T)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
	/* (non-Javadoc)
	 * @see br.com.fiap.pizzaria.dao.GenericDAO#update(T)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
	/* (non-Javadoc)
	 * @see br.com.fiap.pizzaria.dao.GenericDAO#delete(T)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
	/* (non-Javadoc)
	 * @see br.com.fiap.pizzaria.dao.GenericDAO#findAll()
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public List<T> findAll() {
        return entityManager.createQuery((String.format("FROM %s", getTypeClass().getName()))).getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}

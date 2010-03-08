/*
 * Copyright 2005-2008 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl2.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.rice.kns.dao.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.kuali.rice.core.jpa.criteria.QueryByCriteria.QueryByCriteriaType;
import org.kuali.rice.core.jpa.metadata.MetadataManager;
import org.kuali.rice.core.util.OrmUtils;
import org.kuali.rice.kns.bo.PersistableBusinessObject;
import org.kuali.rice.kns.bo.PersistableBusinessObjectExtension;
import org.kuali.rice.kns.dao.BusinessObjectDao;
import org.kuali.rice.kns.service.PersistenceStructureService;
import org.kuali.rice.kns.util.KNSPropertyConstants;
import org.kuali.rice.kns.util.ObjectUtils;
import org.springframework.dao.DataAccessException;

/**
 * This class is the JPA implementation of the BusinessObjectDao interface.
 */
@SuppressWarnings("unchecked")
public class BusinessObjectDaoJpa implements BusinessObjectDao {

	@PersistenceContext
	private EntityManager entityManager;

	private PersistenceStructureService persistenceStructureService;

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findBySinglePrimaryKey(java.lang.Class, java.lang.Object)
	 */
	public PersistableBusinessObject findBySinglePrimaryKey(Class clazz, Object primaryKey) {
		return (PersistableBusinessObject) entityManager.find(clazz, primaryKey);
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findByPrimaryKey(java.lang.Class,
	 *      java.util.Map)
	 */
	public PersistableBusinessObject findByPrimaryKey(Class clazz, Map primaryKeys) { 
		if (primaryKeys == null || primaryKeys.isEmpty()) {
			return null;
		}
		PersistableBusinessObject bo = null;
		try {
			bo = (PersistableBusinessObject) new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, buildJpaCriteria(clazz, primaryKeys)).toQuery().getSingleResult();
		} catch (PersistenceException e) {}
		return bo;
	}
	
	/**
	 * Retrieves an object, based on its PK object
	 * 
	 * @param clazz the class of the object to retrieve
	 * @param pkObject the value of the primary key
	 * @return the retrieved PersistableBusinessObject
	 */
	public PersistableBusinessObject findByPrimaryKeyUsingKeyObject(Class clazz, Object pkObject) { 
		if (pkObject == null) {
			return null;
		}
		PersistableBusinessObject bo = null;
		try {
			bo = (PersistableBusinessObject) entityManager.find(clazz, pkObject);
		} catch (PersistenceException e) {}
		return bo;
	}

	/**
	 * Retrieves all of the records for a given class name.
	 * 
	 * @param clazz -
	 *            the name of the object being used, either KualiCodeBase or a
	 *            subclass
	 * @return Collection
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findAll(java.lang.Class)
	 */
	public Collection findAll(Class clazz) {
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, new org.kuali.rice.core.jpa.criteria.Criteria(clazz.getName())).toQuery().getResultList();
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findAllOrderBy(java.lang.Class,
	 *      java.lang.String, boolean)
	 */
	public Collection findAllOrderBy(Class clazz, String sortField, boolean sortAscending) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = new org.kuali.rice.core.jpa.criteria.Criteria(clazz.getName());
		criteria.orderBy(sortField, sortAscending);
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, criteria).toQuery().getResultList();
	}

	/**
	 * This is the default impl that comes with Kuali - uses OJB.
	 * 
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findMatching(java.lang.Class,
	 *      java.util.Map)
	 */
	public Collection findMatching(Class clazz, Map fieldValues) {
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, buildJpaCriteria(clazz, fieldValues)).toQuery().getResultList();
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findAllActive(java.lang.Class)
	 */
	public Collection findAllActive(Class clazz) {
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, buildActiveJpaCriteria(clazz)).toQuery().getResultList();
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findAllActive(java.lang.Class)
	 */
	public Collection findAllInactive(Class clazz) {
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, buildInactiveJpaCriteria(clazz)).toQuery().getResultList();
	}
	
	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findAllActiveOrderBy(java.lang.Class,
	 *      java.lang.String, boolean)
	 */
	public Collection findAllActiveOrderBy(Class clazz, String sortField, boolean sortAscending) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = buildActiveJpaCriteria(clazz);
		criteria.orderBy(sortField, sortAscending);
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, criteria).toQuery().getResultList();
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findMatchingActive(java.lang.Class,
	 *      java.util.Map)
	 */
	public Collection findMatchingActive(Class clazz, Map fieldValues) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = buildJpaCriteria(clazz, fieldValues);
		criteria.and(buildActiveJpaCriteria(clazz));
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, criteria).toQuery().getResultList();
	}

	/**
	 * This is the default impl that comes with Kuali - uses OJB.
	 * 
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#countMatching(java.lang.Class,
	 *      java.util.Map)
	 */
	public int countMatching(Class clazz, Map fieldValues) {
		return ((Long) new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, buildJpaCriteria(clazz, fieldValues)).toCountQuery().getSingleResult()).intValue();
	}

	/**
	 * This is the default impl that comes with Kuali - uses OJB.
	 * 
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#countMatching(java.lang.Class,
	 *      java.util.Map, java.util.Map)
	 */
	public int countMatching(Class clazz, Map positiveFieldValues, Map negativeFieldValues) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = buildJpaCriteria(clazz, positiveFieldValues);
		criteria.and(buildNegativeJpaCriteria(clazz, negativeFieldValues));
		return ((Long) new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, criteria).toCountQuery().getSingleResult()).intValue();
	}

	/**
	 * This is the default impl that comes with Kuali - uses OJB.
	 * 
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#findMatching(java.lang.Class,
	 *      java.util.Map)
	 */
	public Collection findMatchingOrderBy(Class clazz, Map fieldValues, String sortField, boolean sortAscending) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = buildJpaCriteria(clazz, fieldValues);
		criteria.orderBy(sortField, sortAscending);
		return new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, criteria).toQuery().getResultList();
	}

	/**
	 * Saves a business object.
	 * 
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#save(org.kuali.rice.kns.bo.PersistableBusinessObject)
	 */
	public PersistableBusinessObject save(PersistableBusinessObject bo) throws DataAccessException {
		/* KC determined this is not needed for JPA
		// if collections exist on the BO, create a copy and use to process the
		// collections to ensure
		// that removed elements are deleted from the database
		Set<String> boCollections = getPersistenceStructureService().listCollectionObjectTypes(bo.getClass()).keySet();
		PersistableBusinessObject savedBo = null;
		if (!boCollections.isEmpty()) {
			// refresh bo to get db copy of collections
			savedBo = (PersistableBusinessObject) ObjectUtils.deepCopy(bo);
			for (String boCollection : boCollections) {
				if (getPersistenceStructureService().isCollectionUpdatable(savedBo.getClass(), boCollection)) {
					savedBo.refreshReferenceObject(boCollection);
				}
			}
		}
		*/
		return reattachAndSave(bo);
	}
	
		

	/**
	 * Saves a business object.
	 * 
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#save(org.kuali.rice.kns.bo.PersistableBusinessObject)
	 */
	public void save(List businessObjects) throws DataAccessException {
		for (Iterator i = businessObjects.iterator(); i.hasNext();) {
			Object bo = i.next();
			reattachAndSave((PersistableBusinessObject) bo);
		}
	}

	/**
	 * Deletes the business object passed in.
	 * 
	 * @param bo
	 * @throws DataAccessException
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#delete(org.kuali.rice.kns.bo.PersistableBusinessObject)
	 */
	public void delete(PersistableBusinessObject bo) {
		PersistableBusinessObject realPBO = (PersistableBusinessObject)ObjectUtils.materializeObject(bo);
		if (realPBO != null) {
			if (realPBO.getExtension() != null) {
				delete(realPBO.getExtension());
			}
			if (entityManager.contains(realPBO)) {
				entityManager.remove(realPBO);
			} else {
				final PersistableBusinessObject foundBO = (PersistableBusinessObject)entityManager.find(realPBO.getClass(), MetadataManager.getPersistableBusinessObjectPrimaryKeyObject(realPBO));
				if (foundBO != null) {
					entityManager.remove(foundBO);
				}
			}
		}
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#delete(java.util.List)
	 */
	public void delete(List<? extends PersistableBusinessObject> boList) {
		for (PersistableBusinessObject bo : boList) {
			delete(bo);
		}
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#deleteMatching(java.lang.Class,
	 *      java.util.Map)
	 */
	public void deleteMatching(Class clazz, Map fieldValues) {
		// Rice JPA MetadataManager
		new org.kuali.rice.core.jpa.criteria.QueryByCriteria(entityManager, buildJpaCriteria(clazz, fieldValues), QueryByCriteriaType.DELETE).toQuery().executeUpdate();
	}

	/**
	 * @see org.kuali.rice.kns.dao.BusinessObjectDao#retrieve(org.kuali.rice.kns.bo.PersistableBusinessObject)
	 */
	public PersistableBusinessObject retrieve(PersistableBusinessObject object) {
		PersistableBusinessObject pbo = null;
		Object pkObject = MetadataManager.getPersistableBusinessObjectPrimaryKeyObject(object);
		if (pkObject != null) {
			pbo = (PersistableBusinessObject) entityManager.find(object.getClass(), pkObject);
			if (pbo != null && pbo.getExtension() != null) {
				pbo.setExtension((PersistableBusinessObjectExtension) entityManager.find(pbo.getExtension().getClass(), MetadataManager.getPersistableBusinessObjectPrimaryKeyObjectWithValuesForExtension(pbo, pbo.getExtension())));
			}
		}
		return pbo;
	}

	private org.kuali.rice.core.jpa.criteria.Criteria buildJpaCriteria(Class clazz, Map fieldValues) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = new org.kuali.rice.core.jpa.criteria.Criteria(clazz.getName());
		for (Iterator i = fieldValues.entrySet().iterator(); i.hasNext();) {
			Map.Entry e = (Map.Entry) i.next();

			String key = (String) e.getKey();
			Object value = e.getValue();
			if (value == null) {
				continue;
			} else if (value instanceof Collection) {
				criteria.in(key, (Collection)value);
			} else {
				criteria.eq(key, value);
			}
		}
		return criteria;
	}

	private org.kuali.rice.core.jpa.criteria.Criteria buildActiveJpaCriteria(Class clazz) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = new org.kuali.rice.core.jpa.criteria.Criteria(clazz.getName());
		criteria.eq(KNSPropertyConstants.ACTIVE, true);
		return criteria;
	}

	private org.kuali.rice.core.jpa.criteria.Criteria buildInactiveJpaCriteria(Class clazz) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = new org.kuali.rice.core.jpa.criteria.Criteria(clazz.getName());
		criteria.eq(KNSPropertyConstants.ACTIVE, false);
		return criteria;
	}

	private org.kuali.rice.core.jpa.criteria.Criteria buildNegativeJpaCriteria(Class clazz, Map negativeFieldValues) {
		org.kuali.rice.core.jpa.criteria.Criteria criteria = new org.kuali.rice.core.jpa.criteria.Criteria(clazz.getName());
		for (Iterator i = negativeFieldValues.entrySet().iterator(); i.hasNext();) {
			Map.Entry e = (Map.Entry) i.next();

			String key = (String) e.getKey();
			Object value = e.getValue();
			if (value instanceof Collection) {
				criteria.notIn(key, (List) value);
			} else {
				criteria.ne(key, value);
			}
		}

		return criteria;
	}

	/**
	 * Gets the persistenceStructureService attribute.
	 * 
	 * @return Returns the persistenceStructureService.
	 */
	protected PersistenceStructureService getPersistenceStructureService() {
		return persistenceStructureService;
	}

	/**
	 * Sets the persistenceStructureService attribute value.
	 * 
	 * @param persistenceStructureService
	 *            The persistenceStructureService to set.
	 */
	public void setPersistenceStructureService(PersistenceStructureService persistenceStructureService) {
		this.persistenceStructureService = persistenceStructureService;
	}

	private PersistableBusinessObject reattachAndSave(PersistableBusinessObject bo) {
		PersistableBusinessObject attachedBo = findByPrimaryKey(bo.getClass(), MetadataManager.getPersistableBusinessObjectPrimaryKeyValuePairs(bo));
		PersistableBusinessObject newBo = attachedBo;
		if (attachedBo == null) {
			newBo = entityManager.merge(bo);
			if (bo.getExtension() != null) {
				entityManager.merge(bo.getExtension());
			}
		} else {
			if (bo.getExtension() != null) {
				PersistableBusinessObject attachedBoe = findByPrimaryKey(bo.getExtension().getClass(), MetadataManager.getPersistableBusinessObjectPrimaryKeyValuePairs(bo.getExtension()));
				OrmUtils.reattach(attachedBoe, bo.getExtension());
				attachedBo.setExtension((PersistableBusinessObjectExtension) attachedBoe);
				entityManager.merge(attachedBoe);
			}
			OrmUtils.reattach(attachedBo, bo);
			newBo = entityManager.merge(attachedBo);
		}
		return newBo;
	}

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	
}

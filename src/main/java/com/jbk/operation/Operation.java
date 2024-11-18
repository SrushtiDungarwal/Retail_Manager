package com.jbk.operation;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jbk.config.HibernateConfig;
import com.jbk.entity.Product;

public class Operation {

	SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public String addProduct(Product product) {

		try {

			Session session = sessionFactory.openSession();

			Product dbproduct = session.get(Product.class, product.getProductId());

			if (dbproduct == null) {

				session.save(product);
				session.beginTransaction().commit();

				return "Added Successfully";
			} else {
				return "product already exist";
			}
		} catch (Exception e) {
			return "Something went wrong";
		}
	}

	public String deleteProduct(int productId) {
		Session session = sessionFactory.openSession();

		try {
			Product dbProduct = session.get(Product.class, productId);

			if (dbProduct != null) {

				session.delete(dbProduct);
				session.beginTransaction().commit();
				return "Product deleted successfully";
			} else {
				return "Product does not exist";
			}

		} catch (Exception e) {
			return "Something went wrong";
		}

	}

	public Object getProductById(int productId) {
		Session session = sessionFactory.openSession();
		try {
			Product dbProduct = session.get(Product.class, productId);
			if (dbProduct != null) {
				return dbProduct;
			} else {
				return "Product does not exists";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		try {
			Product dbProduct = session.get(Product.class, product.getProductId());
			if (dbProduct != null) {
				session.evict(dbProduct);
				session.update(product);
				session.beginTransaction().commit();
				return "Updated Successfully";
			} else {
				return "Product does not exists";
			}
		} catch (Exception e) {
			return "Something went wrong";
		}

	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getAllProductsByOrder() {

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getLimitedProduct() {

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setMaxResults(2);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProductByName(String name) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", name));
			list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getProductByHigherPrice(double price) {

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", price));
			list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public long getProductCount() {

		Session session = sessionFactory.openSession();
		long count = 0;

		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.rowCount());
			List<Long> list = criteria.list();

			if (!list.isEmpty()) {
				count = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Product> queryEx1() {

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			String hql = "FROM Product";
			Query query = session.createQuery(hql);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> queryEx2() {

		Session session = sessionFactory.openSession();
		List<Object[]> list = null;
		try {
			String hql = "SELECT productId, productName, productPrice FROM Product";
			Query query = session.createQuery(hql);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> queryEx3() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			String hql = "FROM Product WHERE productName=:pName";
			Query query = session.createQuery(hql);
			query.setString("pName", "book");
			list = query.list();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<String> withoutQueryEx1() {
		Session session = sessionFactory.openSession();
		List<String> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.property("productName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}

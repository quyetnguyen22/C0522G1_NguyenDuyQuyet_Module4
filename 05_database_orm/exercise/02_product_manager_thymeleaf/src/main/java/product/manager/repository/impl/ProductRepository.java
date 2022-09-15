package product.manager.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product.manager.model.Product;
import product.manager.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productMap = new HashMap<>();

//    static {
//        productMap.put(1, new Product(1, "TH-True Milk", 7500, "No sugar", "TH company"));
//        productMap.put(2, new Product(2, "TH-True Milk", 7500, "less sugar", "TH company"));
//        productMap.put(3, new Product(3, "TH-True Milk", 7500, "more sugar", "TH company"));
//        productMap.put(4, new Product(4, "Tiger", 15000, "Platinum", "Tiger company"));
//    }

    @Override
    public List<Product> productList() {
        Session session = null;
        List<Product> musicList;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            musicList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        return new ArrayList<>(productMap.values());
        return musicList;
    }

    @Override
    public boolean addNewProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        productMap.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean editProduct(Product product) {
        productMap.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        productMap.remove(id);
        return true;
    }

    @Override
    public Product showDetail(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getProductName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}

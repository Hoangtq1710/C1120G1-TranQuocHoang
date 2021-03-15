package exercise_product_management.service;

import exercise_product_management.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> products;

    static  {
        products = new HashMap<>();
        products.put(1,new Product(1,"Sony",600,"Sản phẩm của Sony","Sony Inc"));
        products.put(2,new Product(2,"Hitachi",450,"Sản phẩm của Hitachi","Hitachi Inc"));
        products.put(3,new Product(3,"Iphone",1200,"Sản phẩm của Apple","Apple Inc"));
        products.put(4,new Product(4,"Oppo",750,"Sản phẩm của Oppo","Oppo Inc"));
        products.put(5,new Product(5,"Samsung",800,"Sản phẩm của Samsung","Samsung Inc"));
        products.put(6,new Product(6,"Nokia",650,"Sản phẩm của Nokia","Nokia Inc"));
        products.put(7,new Product(7,"Vsmart",400,"Sản phẩm của Vsmart","Vsmart Inc"));
        products.put(8,new Product(8,"RedMi",600,"Sản phẩm của RedMi","RedMi Inc"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product search(String name) {
        for(Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}

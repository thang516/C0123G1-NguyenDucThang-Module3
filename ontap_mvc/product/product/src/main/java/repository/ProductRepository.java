package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Trà Sữa", "19k", "Có Trà Và Sữa", "GongCha"));
        productList.add(new Product(2, "Trà Đào", "34k", "Có Trà Và Đào", "GongCha"));
        productList.add(new Product(3, "Trà Chanh", "54k", "Có Trà Và Chanh", "GongCha"));
        productList.add(new Product(4, "Trà Tắc", "43k", "Có Trà Và Tắc", "GongCha"));
        productList.add(new Product(5, "Trà Gừng", "45k", "Có Trà Và Gừng", "GongCha"));
        productList.add(new Product(6, "Trà Ôlong", "34k", "Có Trà Và Ôlong", "GongCha"));

    }

    @Override
    public List<Product> getAll() {

        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(i);
                break;
            }
        }

    }
}

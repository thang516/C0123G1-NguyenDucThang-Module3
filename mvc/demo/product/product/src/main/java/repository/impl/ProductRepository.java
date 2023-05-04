package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Trà Sữa ", "25k", "Có Trà Và Sữa ", "GongCha"));
        productList.add(new Product(2, "Trà Đào ", "35k", "Có Trà Và Đào ", "GongCha"));
        productList.add(new Product(3, "Trà Gừng ", "20k", "Có Trà Và Gừng ", "GongCha"));
        productList.add(new Product(4, "Trà Chanh ", "25k", "Có Trà Và Chanh ", "GongCha"));
        productList.add(new Product(5, "Trà Ôlong ", "40k", "Có Trà Và Ôlong ", "GongCha"));
        productList.add(new Product(6, "Trà Tắc  ", "45k", "Có Trà Và Tắc ", "GongCha"));
        productList.add(new Product(7, "Trà Sen ", "25k", "Có Trà Và Sen ", "GongCha"));

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

    @Override
    public void edit(Product product) {
        int id = product.getId();
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.set(i, product);
                break;
            }
        }

    }
}

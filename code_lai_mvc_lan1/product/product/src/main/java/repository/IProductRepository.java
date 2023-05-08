package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    boolean save(Product product);

    boolean delete(int id);
}

package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.getAll();
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);

    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }
}

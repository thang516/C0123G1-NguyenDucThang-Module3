package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private final IProductRepository productRepository = new ProductRepository() ;
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
}

package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final  String SELECT_ALL = "SELECT * FROM product ;";
    private final  String CREATE_PRODUCT = "INSERT INTO product VALUES(?,?,?,?);";
    private final  String DELETE_PRODUCT = "CALL delete_by_id(?);";

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet  resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name =resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                String description =resultSet.getString("description");
                Product product = new Product(id,name,price,description);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection connection =BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
               preparedStatement.setString(2, product.getName());
               preparedStatement.setFloat(3, product.getPrice());
               preparedStatement.setString(4, product.getDescription());
               preparedStatement.setInt(1, product.getId());
               return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement =connection.prepareCall(DELETE_PRODUCT);
            callableStatement.setInt(1,id);
            return callableStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

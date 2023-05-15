package Repository;

import model.Contract;
import model.TypeContract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository{

    private static final String SELECT = " SELECT hd.*,ldv.name_contract FROM hop_dong_giao_dich hd \n" +
            " INNER JOIN loai_hop_dong ldv ON ldv.id_contract = hd.id_contract ;";
private static  final  String SELECT_ALL_TYPE = " SELECT * FROM loai_hop_dong ; ";
private static  final  String SAVE = "  INSERT INTO hop_dong_giao_dich(`name`,id_contract,ngay,ngay_ket_thuc) VALUES(?,?,?,?); ";
private static  final  String DELETE = " DELETE FROM hop_dong_giao_dich WHERE id = ?;";
private static  final  String FIND = " SELECT hd.* ,lhd.name_contract FROM  hop_dong_giao_dich hd\n" +
        " INNER JOIN loai_hop_dong lhd ON lhd.id_contract = hd.id_contract  WHERE `name` Like ? ;";
    @Override
    public List<Contract> getAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateStart = resultSet.getString("ngay");
                String dateEnd = resultSet.getString("ngay_ket_thuc");
                int idContract = resultSet.getInt("id_contract");
                String nameContract = resultSet.getString("name_contract");
                TypeContract typeContract = new TypeContract(idContract,nameContract);
                Contract contract = new Contract(id,name,typeContract,dateStart,dateEnd);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public List<TypeContract> getAllTypeContract() {
        List<TypeContract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idContract = resultSet.getInt("id_contract");
                String nameContract = resultSet.getString("name_contract");
                TypeContract typeContract = new TypeContract(idContract,nameContract);
                contractList.add(typeContract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean save(Contract contract) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1,contract.getName());
            preparedStatement.setInt(2,contract.getTypeContract().getIdContract());
            preparedStatement.setString(3,contract.getDateStart());
            preparedStatement.setString(4,contract.getDateEnd());
         return    preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection =BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Contract> find(String nameFind) {
        Connection connection =BaseRepository.getConnectDB();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND);
            preparedStatement.setString(1,'%'+nameFind+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            int id=resultSet.getInt("id");
            String name = resultSet.getString("name");
            int idContract = resultSet.getInt("id_contract");
            String nameContract = resultSet.getString("name_contract");
            TypeContract typeContract = new TypeContract(idContract,nameContract);
            String dateStart = resultSet.getString("ngay");
            String dateEnd = resultSet.getString("ngay_ket_thuc");
            Contract contract = new Contract(id,name,typeContract,dateStart,dateEnd);
                contractList.add(contract);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}

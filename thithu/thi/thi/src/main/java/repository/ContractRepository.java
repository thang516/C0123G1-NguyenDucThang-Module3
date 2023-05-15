package repository;

import model.Contract;
import model.TypeContract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {

    private static final String SELECT ="SELECT hd.* ,lhd.name_contract , hd.ngay , hd.ngay_ket_thuc FROM  hop_dong_giao_dich hd \n" +
            "INNER JOIN loai_hop_dong lhd On lhd.id_contract = hd.id_contract;" ;
    private static final String SELECT_ALL_TYPE_CONTRACT ="SELECT * FROM loai_hop_dong;";

    private static final String SAVE = "INSERT INTO hop_dong_giao_dich (`name`,id_contract,ngay,ngay_ket_thuc) VALUES(?,?,?,?);\n";
    private static final String DELETE = "DELETE FROM hop_dong_giao_dich hd WHERE id = ? ; ";
    private static final String FIND = "SELECT hd.`name`,hd.id_contract,hd.ngay,hd.ngay_ket_thuc, lhd.name_contract FROM hop_dong_giao_dich hd \n" +
            "INNER JOIN loai_hop_dong lhd ON lhd.id_contract = hd.id_contract\n" +
            " WHERE `name` Like ? AND lhd.name_contract LIKE ?";
    private  static  final  String UPDATE = " UPDATE hop_dong_giao_dich SET `name` = ? , id_contract = ? , ngay = ?,ngay_ket_thuc=? WHERE id =? ;";


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
                int idContract = resultSet.getInt("id_contract");
                String contractName = resultSet.getString("name_contract");
                TypeContract typeContract = new TypeContract(idContract,contractName);
                String date = resultSet.getString("ngay");
                String dateEnd = resultSet.getString("ngay_ket_thuc");
                Contract contract =new Contract(id,name,typeContract,date,dateEnd);
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
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idContract = resultSet.getInt("id_contract");
                String contractName = resultSet.getString("name_contract");
                TypeContract typeContract = new TypeContract(idContract,contractName);
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
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Contract> find(String nameFind ,String nameContract) {
        Connection connection = BaseRepository.getConnectDB();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND);
            preparedStatement.setString(1,'%'+nameFind+'%');
            preparedStatement.setString(2,'%'+nameContract+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
//                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int idContract = resultSet.getInt("id_contract");
                String dateStart = resultSet.getString("ngay");
                String dateEnd = resultSet.getString("ngay_ket_thuc");
                String contractName = resultSet.getString("name_contract");
                TypeContract typeContract = new TypeContract(idContract,contractName);
                Contract contract =new Contract(name,typeContract,dateStart,dateEnd);
                contractList.add(contract);
                return contractList;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean edit(Contract contract) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,contract.getName());
            preparedStatement.setInt(2,contract.getTypeContract().getIdContract());
            preparedStatement.setString(3,contract.getDateStart());
            preparedStatement.setString(4,contract.getDateEnd());
            preparedStatement.setInt(5,contract.getId());
        return  preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}
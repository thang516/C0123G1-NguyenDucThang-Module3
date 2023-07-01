package Repository;

import model.Pet;
import model.Phat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepository implements IManagerRepository{
    private static final String SELECT= "SELECT * FROM ve_phat;";
    private static final String INSERT_INTO= "INSERT INTO ve_phat (ten_tai_khoan_bi_phat,id_thu_cung,thong_tin_loi_vi_pham,ngay_gio_vi_pham,so_tien_can_dong_phat) VALUES (?,?,?,?,?) ";

    @Override
    public List<Phat> getAll() {
        Connection connection = BaseRepository.getConnectDB();
        List<Phat> phatList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int phatId = resultSet.getInt("ma_so_ve_phat");
                String user = resultSet.getString("ten_tai_khoan_bi_phat");
                int id = resultSet.getInt("id_thu_cung");
                String information = resultSet.getString("thong_tin_loi_vi_pham");
                String dateTime = resultSet.getString("ngay_gio_vi_pham");
                String money = resultSet.getString("so_tien_can_dong_phat");
                String note = resultSet.getString("ghi_chu_them");
                Phat phat =new Phat(phatId,user,id,information,dateTime,money,note);
                phatList.add(phat);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phatList;
    }

    @Override
    public boolean save(Phat phat) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,phat.getUser());
            preparedStatement.setInt(2,phat.getId());
            preparedStatement.setString(3,phat.getInformation());
            preparedStatement.setString(4,phat.getDateTime());
            preparedStatement.setString(5,phat.getMoney());
            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

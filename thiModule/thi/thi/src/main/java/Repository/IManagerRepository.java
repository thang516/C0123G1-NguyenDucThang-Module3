package Repository;

import model.Phat;

import java.util.List;

public interface IManagerRepository {
    List<Phat> getAll();

    boolean save(Phat phat);
}

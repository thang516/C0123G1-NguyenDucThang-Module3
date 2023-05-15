package Repository;

import model.Contract;
import model.TypeContract;

import java.util.List;

public interface IContractRepository {
    List<Contract> getAll();

    List<TypeContract> getAllTypeContract();

    boolean save(Contract contract);

    boolean delete(int id);

    List<Contract> find(String nameFind);
}

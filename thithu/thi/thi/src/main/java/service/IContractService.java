package service;

import model.Contract;
import model.TypeContract;

import java.util.List;

public interface IContractService {
    List<Contract> getAll();

    List<TypeContract> getAllTypeContract();

    boolean save(Contract contract);

    boolean delete(int id);

    List<Contract> find(String nameFind, String nameContract);

    boolean edit(Contract contract);
}

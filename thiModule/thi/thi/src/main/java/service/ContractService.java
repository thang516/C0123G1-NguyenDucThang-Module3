package service;

import Repository.ContractRepository;
import Repository.IContractRepository;
import model.Contract;
import model.TypeContract;

import java.util.List;

public class ContractService implements IContractService{
    private IContractRepository contractRepository = new ContractRepository();
    @Override
    public List<Contract> getAll() {
        List<Contract> contractList = contractRepository.getAll();
        return contractList;
    }

    @Override
    public List<TypeContract> getAllTypeContract() {
        List<TypeContract> contractList = contractRepository.getAllTypeContract();
        return  contractList;
    }

    @Override
    public boolean save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public boolean delete(int id) {
        return  contractRepository.delete(id);
    }

    @Override
    public  List<Contract> find(String nameFind) {

        List<Contract> contractList = contractRepository.find(nameFind);
        return contractList;
    }


}

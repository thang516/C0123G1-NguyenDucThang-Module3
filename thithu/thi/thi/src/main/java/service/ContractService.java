package service;

import model.Contract;
import model.TypeContract;
import repository.ContractRepository;
import repository.IContractRepository;

import java.util.List;

public class ContractService implements IContractService{
    private IContractRepository contractRepository = new ContractRepository() ;

    @Override
    public List<Contract> getAll() {
        List<Contract> contractList = contractRepository.getAll();
        return contractList;
    }

    @Override
    public List<TypeContract> getAllTypeContract() {
        List<TypeContract> contractList = contractRepository.getAllTypeContract();
        return contractList;
    }

    @Override
    public boolean save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public boolean delete(int id) {
        return contractRepository.delete(id);
    }
//    @Override
//    public List<Contract> getAll() {
//        List<Contract> contractList = contractRepository.getAll();
//        return contractList;
//    }
//
//    @Override
//    public List<TypeContract> getAllTypeContract() {
//        List<TypeContract> typeContractList= contractRepository.getAllTypeContract() ;
//        return typeContractList;
//    }
//
//    @Override
//    public boolean save(Contract contract) {
//       boolean check =  contractRepository.save(contract);
//        return check;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return contractRepository.delete(id);
//    }
//
//    @Override
//    public List<Contract> find(String nameFind,String nameContract) {
//        List<Contract> contractList =  contractRepository.find(nameFind,nameContract);
//        return contractList;
//    }
//
//    @Override
//    public boolean edit(Contract contract) {
//       return contractRepository.edit(contract);
//    }
}

package service;

import Repository.IManagerRepository;
import Repository.ManagerRepository;
import model.Phat;

import java.util.List;

public class ManagerService implements  IManagerService{
    private IManagerRepository managerRepository = new ManagerRepository();
    @Override
    public List<Phat> getAll() {
        List<Phat> phatList = managerRepository.getAll();
        return phatList;
    }

    @Override
    public boolean save(Phat phat) {
        return  managerRepository.save(phat);

    }
}

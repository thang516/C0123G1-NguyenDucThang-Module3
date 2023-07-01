package service;

import model.Phat;

import java.util.List;

public interface IManagerService {
    List<Phat> getAll();

    boolean save(Phat phat);
}

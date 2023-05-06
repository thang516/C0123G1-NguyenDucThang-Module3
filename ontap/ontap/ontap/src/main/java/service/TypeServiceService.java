package service;

import model.TypeServices;

import java.util.List;

public interface TypeServiceService {
    List<TypeServices> getAll();

    void save(TypeServices typeServices);

    void delete(int maDichVu);

    void edit(TypeServices typeServices);
}

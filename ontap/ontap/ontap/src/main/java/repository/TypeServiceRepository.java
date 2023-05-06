package repository;

import model.TypeServices;

import java.util.List;

public interface TypeServiceRepository  {
    List<TypeServices> getAll();

    void save(TypeServices typeServices);

    void delete(int maDichVu);

    void edit(TypeServices typeServices);
}

package service;

import model.TypeServices;
import repository.TypeSRepository;
import repository.TypeServiceRepository;

import java.util.List;

public class TypeSService implements  TypeServiceService{
    private TypeServiceRepository typeServiceRepository = new TypeSRepository() ;
    @Override
    public List<TypeServices> getAll() {
        List<TypeServices> typeSServiceList = typeServiceRepository.getAll();
        return typeSServiceList;
    }

    @Override
    public void save(TypeServices typeServices) {
        typeServiceRepository.save(typeServices);
    }

    @Override
    public void delete(int maDichVu) {
        typeServiceRepository.delete(maDichVu);
    }

    @Override
    public void edit(TypeServices typeServices) {
        typeServiceRepository.edit(typeServices);
    }
}

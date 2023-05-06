package repository;

import model.TypeServices;

import java.util.ArrayList;
import java.util.List;

public class TypeSRepository  implements  TypeServiceRepository{
    public  static  List<TypeServices> typeServicesList = new ArrayList<>();
    static {
        typeServicesList.add(new TypeServices(1,2,"san1"));
        typeServicesList.add(new TypeServices(2,2,"san2"));
        typeServicesList.add(new TypeServices(3,2,"san3"));
        typeServicesList.add(new TypeServices(4,2,"san4"));
        typeServicesList.add(new TypeServices(5,2,"san5"));

    }
    @Override
    public List<TypeServices> getAll() {

        return typeServicesList;
    }

    @Override
    public void save(TypeServices typeServices) {
        typeServicesList.add(typeServices);
    }

    @Override
    public void delete(int maDichVu) {
        for (int i = 0; i < typeServicesList.size(); i++) {
            if(maDichVu==typeServicesList.get(i).getMaDichVu()){
                typeServicesList.remove(i);
                System.out.println(typeServicesList);
                break;
            }
        }
    }

    @Override
    public void edit(TypeServices typeServices) {
        int maDichVu = typeServices.getMaDichVu();
        int size = typeServicesList.size();
        for (int i = 0; i <size ; i++) {
            if(maDichVu == typeServicesList.get(i).getMaDichVu()){
               typeServicesList.set(i,typeServices);

            }
        }
    }
}

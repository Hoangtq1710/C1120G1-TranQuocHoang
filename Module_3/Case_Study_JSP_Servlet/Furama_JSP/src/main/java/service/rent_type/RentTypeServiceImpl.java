package service.rent_type;

import model.RentType;
import repository.rent_type.RentTypeRepository;
import repository.rent_type.RentTypeRepositoryImpl;

public class RentTypeServiceImpl implements RentTypeService{
    RentTypeRepository repository = new RentTypeRepositoryImpl();
    @Override
    public RentType findById(int id) {
        return repository.findById(id);
    }
}

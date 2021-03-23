package service.customer_type;

import model.CustomerType;
import repository.customer_type.CustomerTypeRepository;
import repository.customer_type.CustomerTypeRepositoryImpl;

public class CustomerTypeServiceImpl implements CustomerTypeService{
    CustomerTypeRepository repository = new CustomerTypeRepositoryImpl();
    @Override
    public CustomerType findCusTypeById(int id) {
        return repository.findCusTypeById(id);
    }
}

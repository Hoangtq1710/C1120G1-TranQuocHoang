package service.service_type;

import model.ServiceType;
import repository.service_type.ServiceTypeRepository;
import repository.service_type.ServiceTypeRepositoryImpl;

public class ServiceTypeServiceImpl implements ServiceTypeService{
    ServiceTypeRepository repository = new ServiceTypeRepositoryImpl();
    @Override
    public ServiceType findById(int id) {
        return repository.findById(id);
    }
}

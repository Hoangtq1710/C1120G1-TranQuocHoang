package service.service;

import model.Service;
import repository.service.ServiceRepository;
import repository.service.ServiceRepositoryImpl;

import java.util.List;

public class ServiceServiceImpl implements ServiceService{

    ServiceRepository repository = new ServiceRepositoryImpl();

    @Override
    public List<Service> findAllService() {
        return repository.findAllService();
    }

    @Override
    public void save(Service service) {
        repository.save(service);
    }

    @Override
    public Service findServiceById(String id) {
        return repository.findServiceById(id);
    }

    @Override
    public void update(String id, Service service) {
        repository.update(id, service);
    }

    @Override
    public void remove(String id) {
        repository.remove(id);
    }

    @Override
    public List<Service> search(String search) {
        return repository.search(search);
    }

    @Override
    public List<Service> sortService(String sortBy) {
        return repository.sortService(sortBy);
    }
}

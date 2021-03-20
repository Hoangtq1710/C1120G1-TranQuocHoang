package repository.service;

import model.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> findAllService();

    void save(Service service);

    Service findServiceById(String id);

    void update(String id, Service service);

    void remove(String id);

    List<Service> search(String search);

    List<Service> sortService(String sortBy);
}

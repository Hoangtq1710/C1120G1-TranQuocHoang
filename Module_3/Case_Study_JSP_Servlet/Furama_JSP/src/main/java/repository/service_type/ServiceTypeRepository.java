package repository.service_type;

import model.ServiceType;

public interface ServiceTypeRepository {
    ServiceType findById(int id);
}

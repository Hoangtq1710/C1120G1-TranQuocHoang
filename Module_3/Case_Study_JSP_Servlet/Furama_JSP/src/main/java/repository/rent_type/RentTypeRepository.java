package repository.rent_type;

import model.RentType;

public interface RentTypeRepository {
    RentType findById(int id);
}

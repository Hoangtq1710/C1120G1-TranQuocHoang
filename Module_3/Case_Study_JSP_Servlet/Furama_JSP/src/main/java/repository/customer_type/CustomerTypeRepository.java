package repository.customer_type;

import model.CustomerType;

public interface CustomerTypeRepository {

    CustomerType findCusTypeById(int id);

}

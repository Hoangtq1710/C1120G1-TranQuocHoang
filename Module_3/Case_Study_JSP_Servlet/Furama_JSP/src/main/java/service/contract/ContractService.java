package service.contract;

import model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAllContract();

    void save(Contract contract);

    Contract findContractById(String id);

    void update(String id, Contract contract);

    void remove(String id);

    List<Contract> search(String search);

    List<Contract> sortContract(String sortBy);
}

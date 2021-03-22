package service.contract;

import model.Contract;
import repository.contract.ContractRepository;
import repository.contract.ContractRepositoryImpl;

import java.util.List;

public class ContractServiceImpl implements ContractService{
    ContractRepository repository = new ContractRepositoryImpl();
    @Override
    public List<Contract> findAllContract() {
        return repository.findAllContract();
    }

    @Override
    public void save(Contract contract) {
        repository.save(contract);
    }

    @Override
    public Contract findContractById(String id) {
        return repository.findContractById(id);
    }

    @Override
    public void update(String id, Contract contract) {
        repository.update(id, contract);
    }

    @Override
    public void remove(String id) {
        repository.remove(id);
    }

    @Override
    public List<Contract> search(String search) {
        return repository.search(search);
    }

    @Override
    public List<Contract> sortContract(String sortBy) {
        return repository.sortContract(sortBy);
    }
}

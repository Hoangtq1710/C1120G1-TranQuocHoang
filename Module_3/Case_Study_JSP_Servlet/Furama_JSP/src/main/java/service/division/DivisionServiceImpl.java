package service.division;

import model.Division;
import repository.division.DivisionRepository;
import repository.division.DivisionRepositoryImpl;

public class DivisionServiceImpl implements DivisionService{
    DivisionRepository repository = new DivisionRepositoryImpl();
    @Override
    public Division findById(int id) {
        return repository.findById(id);
    }
}

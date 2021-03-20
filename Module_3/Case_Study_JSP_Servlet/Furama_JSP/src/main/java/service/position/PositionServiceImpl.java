package service.position;

import model.Position;
import repository.position.PositionRepository;
import repository.position.PositionRepositoryImpl;

public class PositionServiceImpl implements PositionService{

    PositionRepository repository = new PositionRepositoryImpl();
    @Override
    public Position findById(int id) {
        return repository.findById(id);
    }
}

package repository.position;

import model.Position;

public interface PositionRepository {

    Position findById(int id);
}

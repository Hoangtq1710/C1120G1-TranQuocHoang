package repository.division;

import model.Division;

public interface DivisionRepository {
    Division findById(int id);
}

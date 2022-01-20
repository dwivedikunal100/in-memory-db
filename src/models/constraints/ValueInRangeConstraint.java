package models.constraints;

import exceptions.DataTypeInvalidException;

public class ValueInRangeConstraint implements Constraint {

    @Override
    public void apply(Object object) {

        if (object == null) {
            return;
        }
        if (object instanceof Integer) {
            Integer val = (Integer) object;
            if (val < -1024 || val > 1024)
                throw new DataTypeInvalidException();
        } else {
            throw new DataTypeInvalidException();
        }
    }
}

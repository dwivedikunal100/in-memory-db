package models.constraints;

import exceptions.DataTypeInvalidException;

public class StringLengthConstraint implements Constraint {

    @Override
    public void apply(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof String) {
            String val = (String) object;
            if (val.length() > 21)
                throw new DataTypeInvalidException();
        } else {
            throw new DataTypeInvalidException();
        }
    }

}

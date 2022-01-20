package models.datatypes;

import exceptions.DataTypeInvalidException;
import models.constraints.Constraint;

import java.util.List;

public class IntDataType extends DataType<Integer> {

    public IntDataType(List<Constraint> constraintList){
        this.constraints = constraintList;
    }

    @Override
    public void validate(Integer value) {
        for(Constraint constraint: constraints){
            constraint.apply(value);
        }
    }

    @Override
    public String toString() {
        return "IntDataType{}";
    }
}

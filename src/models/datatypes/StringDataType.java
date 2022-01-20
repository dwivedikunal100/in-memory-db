package models.datatypes;

import exceptions.DataTypeInvalidException;
import models.constraints.Constraint;

import java.util.List;

public class StringDataType extends DataType<String> {

    public StringDataType(List<Constraint> constraintList){
        this.constraints = constraintList;
    }

    public void validate(String value) {
        for(Constraint constraint: constraints){
            constraint.apply(value);
        }
    }

    @Override
    public String toString() {
        return "StringDataType{}";
    }
}

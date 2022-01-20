package models.datatypes;

import models.constraints.Constraint;

import java.util.List;

public abstract class DataType<T>{
   List<Constraint> constraints;
   abstract void validate(T value);
}

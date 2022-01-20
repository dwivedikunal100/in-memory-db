package models;


import models.constraints.Constraint;
import models.datatypes.DataType;
import models.datatypes.IntDataType;
import models.datatypes.StringDataType;

import java.util.List;

public class Value<T> implements Comparable<Value>{
    T value;
    DataType dataType;

    public Value(T value, DataType dataType, List<Constraint> columnConstraints){
        this.dataType = dataType;
        this.value = value;

        for(Constraint constraints: columnConstraints){
            constraints.apply(value);
        }

        if(dataType instanceof StringDataType){
            ((StringDataType)dataType).validate((String)value);
        } else{
            ((IntDataType)dataType).validate(Integer.parseInt((String)value));
        }


    }




    @Override
    public int compareTo(Value o) {
      String t = (String)this.value;
      String v= (String)o.value;
        return t.compareTo(v);
    }


    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                ", dataType=" + dataType +
                '}';
    }
}

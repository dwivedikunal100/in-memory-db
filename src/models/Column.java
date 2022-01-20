package models;

import models.constraints.Constraint;
import models.datatypes.DataType;

import java.util.HashMap;
import java.util.List;

public class Column {
    String colName;
    List<Constraint> columnConstraints;
    DataType dataType;
    HashMap<Value,Integer> values;


    public Column(String colName, List<Constraint> columnConstraints, DataType dataType){
        this.colName = colName;
        this.columnConstraints = columnConstraints;
        this.dataType = dataType;
        values = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Column{" +
                "colName='" + colName + '\'' +
                ", columnConstraints=" + columnConstraints +
                ", dataType=" + dataType +
                ", values=" + values +
                '}';
    }
}

package models;

import models.constraints.Constraint;
import models.datatypes.DataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Table {
    String tableName;
    HashMap<String, Column> columnHashMap;
    HashMap<Integer, List<Value>> rows;

    static Integer counter = 0;

    public Table(String tableName, HashMap<String, List<Constraint>> columns, HashMap<String, DataType> colDataType) {
        this.tableName = tableName;
        this.columnHashMap = new HashMap<>();
        this.rows = new HashMap<>();
        for (String colName : columns.keySet()) {
            columnHashMap.put(colName, new Column(colName, columns.get(colName), colDataType.get(colName)));
        }

    }

    public void addValue(HashMap<String, String> rows) {
        List<Value> values = new ArrayList<>();
        for (String key : rows.keySet()) {
            Column column = columnHashMap.get(key);
            String temp = rows.get(key);
            Value value = new Value(temp, column.dataType, column.columnConstraints);
            column.values.put(value, counter);
            values.add(value);
        }
        this.rows.put(counter, values);
        counter++;
    }

    public String searchValue(String colName, String search) {
        if (columnHashMap.containsKey(colName) == false) {
            return "Column doesnot exists";
        }
        try {
            Column column = columnHashMap.get(colName);
            //TODO:Correct the logic
            Value value = new Value(search, column.dataType, column.columnConstraints);

            if (column.values.containsKey(value)) {
                Integer index = column.values.get(value);
                return rows.get(index).toString();
            }
        } catch (Exception e) {

        }

        return "Value not found ";
    }


    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", columnHashMap=" + columnHashMap +
                ", rows=" + rows +
                '}';
    }
}

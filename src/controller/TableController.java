package controller;

import exceptions.TableAlreadyExistsException;
import exceptions.TableNotExistsException;
import models.Column;
import models.Table;
import models.Value;
import models.constraints.Constraint;
import models.datatypes.DataType;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;

public class TableController {

    // Todo: Create TableProcessor which should communicate with TableDao
    HashMap<String, Table> tables;

    public TableController() {
        tables = new HashMap<>();
    }

    public void createTable(String tableName, HashMap<String, List<Constraint>> columns, HashMap<String, DataType> dataTypeHashMap) {
        if (tables.containsKey(tableName)) {
            throw new TableAlreadyExistsException();
        } else {
            tables.put(tableName, new Table(tableName, columns, dataTypeHashMap));
        }

    }

    public void addToTable(String tableName, HashMap<String, String> rows) {
        if (tables.containsKey(tableName) == false) {
            throw new TableNotExistsException();
        } else {
            Table table = tables.get(tableName);
            table.addValue(rows);
        }
    }

    public void searchTable(String tableName, String colName, String value) {
        if (tables.containsKey(tableName) == false) {
            throw new TableNotExistsException();
        } else {
            Table table = tables.get(tableName);
            System.out.println(table.searchValue(colName, value));
        }

    }


}

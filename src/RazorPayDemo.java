import controller.TableController;
import models.constraints.Constraint;
import models.constraints.RequiredConstraint;
import models.constraints.StringLengthConstraint;
import models.constraints.ValueInRangeConstraint;
import models.datatypes.DataType;
import models.datatypes.IntDataType;
import models.datatypes.StringDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RazorPayDemo {

    public static void main(String[] args) {
        TableController controller = new TableController();


        DataType dataType1 = new StringDataType(Collections.singletonList(new StringLengthConstraint()));
        DataType dataType2 = new IntDataType(Collections.singletonList(new ValueInRangeConstraint()));


        HashMap<String,List<Constraint>> cols = new HashMap<>();
        cols.put("abc", Collections.singletonList(new RequiredConstraint()));
        cols.put("def", Collections.singletonList(new RequiredConstraint()));
        HashMap<String,DataType> colData= new HashMap<>();
        colData.put("abc",dataType1);
        colData.put("def",dataType2);

        controller.createTable("Kunal",cols,colData);

        HashMap<String,String> entry1 = new HashMap<>();
        entry1.put("abc","sad");
        entry1.put("def","123");
        controller.addToTable("Kunal",entry1);
        // added to table

        controller.searchTable("Kunal","abc","ew");
        controller.searchTable("Kunal","abc","sad");


    }
}

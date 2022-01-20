package models.constraints;

public class RequiredConstraint implements Constraint{

    @Override
    public void apply(Object object){
        if(object == null || (object instanceof String && ((String)object).equals("null"))){
            throw new NullPointerException();
        }
    }
}

package View;
    
public class displayvalueModel {
    public  Object displayMember;
    public  Object displayvalue;
    public displayvalueModel() {
   
    }
    public displayvalueModel(Object displayMember, Object displayvalue) {
        this.displayMember = displayMember;
        this.displayvalue = displayvalue;
    }
    @Override
    public String toString(){
        return displayMember.toString();
    }

}

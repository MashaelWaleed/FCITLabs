/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 2 
 */

public class Mouse extends Device {
    private String type;
    
    /////////////////////////////
    
    Mouse(String company,String type,String code){
    super(company,code);
    this.type=type;}
    
    ////////////////////////////

    @Override
    public String toString() {
        return "Mouse Details\n\n"+super.toString()+" Mouse Type: "+type;
    }
    ////////////////////////////

    public String getType() {
        return type;
    }

  ///////////////////////////////
    public void setType(String type) {
        this.type = type;
    }
}

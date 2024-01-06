/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 2 
 */

public class Printer extends Device{
  private String type;
  private boolean isColor;
/////////////////////////////////
public Printer (String company,String type,boolean isColor,String code)  {

super(company,code);
this.type=type;
this.isColor=isColor;

}
/////////////////////////////////

    @Override
    public String toString() {
        return "Printer Details\n\n"+super.toString()+"  Color Type: " +((isColor)?"Colored":"Black&white")+" Printer Type :"+type;
    }
//////////////////////////////

    public void setType(String type) {
        this.type = type;
    }

    public void setIsColor(boolean isColor) {
        this.isColor = isColor;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }
  /////////////////////////////////

    public String getType() {
        return type;
    }

    public boolean isIsColor() {
        return isColor;
    }

    public String getCompany() {
        return company;
    }

    public String getDevice_code() {
        return device_code;
    }
    
    
}

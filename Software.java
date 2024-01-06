/*
Name: Mashael Waleed 
ID:
Section number: B3A
Assignment number : 2 
 */

public class Software extends Device{
 private String name;
  private double version;
////////////////////////////////
  
public  Software(String company,double version,String code,String name ){
super(company,code);
this.name=name;
this.version=version;
}
////////////////////////////////

    @Override
    public String toString() {
        return "Software Details\n\n"+"S/W name: "+name+" S/W version: "+version;
    }
    
/////////////////////////////////

    public String getName() {
        return name;
    }

    public double getVersion() {
        return version;
    }

    public String getCompany() {
        return company;
    }

    public String getDevice_code() {
        return device_code;
    }
   //////////////////////////////

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }
    
    
}

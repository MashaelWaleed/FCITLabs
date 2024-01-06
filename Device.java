/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 2 
 */
public abstract class Device {
 protected String company;
 protected String device_code;
    
  /////////////////////////////  
    public Device(){}
    
    public Device(String company,String code){
    this.company=company;
    this.device_code=code;
    }
  ///////////////////////////////
 
    @Override
    public String toString() {
        return "Company :" +company;
    }
    /////////////////////////////

    public String getCompany() {
        return company;
    }

    public String getDevice_code() {
        return device_code;
    }
    //////////////////////////////

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }
    
    
    
    
    
    
}

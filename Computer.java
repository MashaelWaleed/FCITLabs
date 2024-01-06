/*
Name: Mashael Waleed
ID: 
Section number: B3A
Assignment number : 2 
 */
import java.util.ArrayList;


public class Computer extends Device implements Comparable<Computer>{
  private double speed;
  private String modelName;
  private ArrayList<Software>software=new ArrayList(); 
  private Mouse mouse;
  private Printer printer;
  private int totalSoftware;
  //////////////////////////////////////////////////////////////////////////
  public Computer(String company,double speed,String modelName,String code){
  super(company,code);
  this.modelName=modelName;
  this.speed= speed;
  }
  
  //////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
    return "Computer Details \n" +super.toString()+"  Model: " +modelName+"  Speed: "+ speed+" GHz";
    }
  
    ///////////////////////////////////////////////////////////////////////

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setModeIName(String modelName) {
        this.modelName = modelName;
    }


    public void setSoftware(ArrayList<Software> software) {
        this.software = software;
    }

    
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    //////////////////////////////////////////////////////////

    public double getSpeed() {
        return speed;
    }

    public String getModelName() {
        return modelName;
    }

    public ArrayList<Software> getSoftware() {
        return software;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Printer getPrinter() {
        return printer;
    }

    public int getNumOfSoftware() {
        return software.size();
    }
 /////////////////////////////////////////////////////////////////////////////////   
  public void addSoftware(Software software) {
        this.software.add(software);
        totalSoftware++;
      }  
  
 public void removeSoftware(Software software) {
        this.software.remove(software);
   }   
  
  
 ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public int compareTo(Computer computer) {
        if(this.speed>computer.speed)
        return 1;
        else if(computer.speed>this.speed)
        return -1;
        else return 0;
    }

   
    
  
  
}

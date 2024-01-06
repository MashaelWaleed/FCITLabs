/*
Name: Mashael Waleed 
ID: 
Section number: B3A
Assignment number : 2 
 */
//--------------------------------------------------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//----------------------------------------------------------------------------------------------      
public class FCITCompuLabs {

        //creat ArrayList for all devices.......................................................
        static  ArrayList<Device> All_devices=new ArrayList<Device>();
         
        public static void main(String[] args) throws FileNotFoundException {
        //check if the file which we will read from exist then creat scanner;....................
        File file1 = new File("fcitInput.txt");
        if(!file1.exists())
        {System.out.println("The file \"fcitInput\" not found..");
         System.exit(0);}
         Scanner read = new Scanner(file1);
        
        //printWriter for second file ...........................................................
         File file2 = new File("fcitOutPutLab.txt");
         PrintWriter write1 =new PrintWriter(file2);
         
         //printWriter for third file ...........................................................
         File file3 = new File("fcitReportLab.txt");
         PrintWriter write2 =new PrintWriter(file3);
        
         //Start to read and write from first file ..............................................
          write1.println("Welcome to the FCIT Lab  System.");
          SimpleDateFormat time=new SimpleDateFormat("E MMM dd HH:mm:ss z yyy");
          time.setTimeZone(TimeZone.getTimeZone("GMT+3"));
         
          write1.println("Today Date is "+time.format(new Date()));
          write1.println();
        //read command ........................................................................
         while (read.hasNext()){
             String command = read.next();
          if(command.equalsIgnoreCase("Add_Computer")){
             format(write1,command);  write1.println();
             Computer computer =new Computer(read.next(),read.nextDouble(),read.next(),read.next());
             All_devices.add(computer);
             printComputersDetails(write1,computer);
             end(write1); }
         //......................................................................................
          if(command.equalsIgnoreCase("Add_Printer")){
             format(write1,command); write1.println();
             Printer printer = new Printer(read.next(),read.next(),read.nextBoolean(),read.next());
             All_devices.add(printer);
             Print_Device_Details(write1,printer);} 
        //......................................................................................... 
         if(command.equalsIgnoreCase("Add_Mouse")){
             format(write1,command);write1.println();
             Mouse mouse =new Mouse(read.next(),read.next(),read.next());
             All_devices.add(mouse);
             Print_Device_Details(write1,mouse);} 
         //........................................................................................
         if(command.equalsIgnoreCase("Add_Software")){
             format(write1,command);write1.println();
             String name=read.next();
             String [] nameCom= name.split("-");
             Software software=new Software(nameCom[0],read.nextDouble(),read.next(),name);
             All_devices.add(software);
             Print_Device_Details(write1,software); } 
         //........................................................................................
         if(command.equalsIgnoreCase("Install_SW")||command.equalsIgnoreCase("Install_printer")||command.equalsIgnoreCase("Install_mouse")){
             format(write1,command);
             install(read,All_devices,write1); }
         //.........................................................................................
         if(command.equalsIgnoreCase("UnInstall_SW")){
             format(write1,command);
             UnInstall(read,All_devices,write1); }
         //.........................................................................................
         if(command.equalsIgnoreCase("List_All_Computer_Configuration")){
            
         format(write2,command);
         for(int i =0;i<All_devices.size();i++){
         if(All_devices.get(i) instanceof Computer){
            write2.println("---------Computer No "+(i+1)+" ---------");
            write2.println();
            write2.println();
            printComputersDetails(write2,(Computer)All_devices.get(i));
            write2.println();  }}}
        //........................................................................................... 
         if(command.equalsIgnoreCase("List_Computer_With_SW")){
           String Micro = read.next();
           format(write2,"List_Computer_With_Microsoft_Software");
           for(int i =0;i<All_devices.size();i++){
           if(All_devices.get(i) instanceof Computer){
           for(int j=0;j<((Computer)All_devices.get(i)).getNumOfSoftware();j++){
           if(((Computer)All_devices.get(i)).getSoftware().get(j).getName().equalsIgnoreCase(Micro)){
             write2.println("---------Computer No "+(i+1)+" ---------");
             write2.println();
             write2.println("The computer Company : "+All_devices.get(i).getCompany()+" Model: "+((Computer)All_devices.get(i)).getModelName());
             write2.println();} } } }}
       
        //...........................................................................................  
         if(command.equalsIgnoreCase("List_Computer_Speed_>")){
         int n = read.nextInt();
         format(write2,"List_Computer_Speed_>"+n);
             for(int i =0;i<All_devices.size();i++){
             if(All_devices.get(i) instanceof Computer){
             if(((Computer)All_devices.get(i)).getSpeed()>n){
             write2.println("---------Computer No "+(i+1)+" ---------");
             write2.println();
             write2.println("The computer Company : "+All_devices.get(i).getCompany()+" Model: "+((Computer)All_devices.get(i)).getModelName());
             write2.println();  }  } }}
         
        //............................................................................................  
          if(command.equalsIgnoreCase("Compare_Computer_Speed")){
               format(write2,command);
               String c= read.next();String c1=read.next();
               Computer Com1=null; Computer Com=null;
               Com =searchComputer(c); Com1 =searchComputer(c1);
        //compare speed using the method compareTo...................................................
                int fast= Com.compareTo(Com1);
                if(fast==1)
                write2.println("("+Com.getCompany()+" , "+Com.getModelName()+","+Com.getSpeed()+") ****** Faster**** than ("+
                        Com1.getCompany()+" , "+Com1.getModelName()+","+Com1.getSpeed()+")");
                else if(fast==-1)
                write2.println("("+Com1.getCompany()+" , "+Com1.getModelName()+","+Com1.getSpeed()+") ****** Faster**** than ("+
                        Com.getCompany()+" , "+Com.getModelName()+","+Com.getSpeed()+")");
                else    write2.println("("+Com1.getCompany()+" , "+Com1.getModelName()+","+Com1.getSpeed()+") ****** Equal****  ("+ 
                        Com.getCompany()+" , "+Com.getModelName()+","+Com.getSpeed()+")");
                 }
         
          //............................................................................................  
          else if(command.equalsIgnoreCase("Quit")){ break; } }
                 read.close();
                 write1.flush();
                 write1.close();
                 write2.flush();
                 write2.close(); 
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void install(Scanner read,ArrayList<Device>All_devices,PrintWriter write1){
Computer target=null; 
String computer = read.next(); String dev=read.next();Device myDevice=null;
        //search for Compuiter........................................................................................................       
        target =searchComputer(computer);
              
        //search for others devices....................................................................................................
         for(int j = 0 ;j<All_devices.size();j++){
         if (All_devices.get(j).getDevice_code().equals(dev)){
         myDevice=All_devices.get(j); }}
         
        //type of the device//
        //*softwares*//..........................................................................................................     
         if(myDevice instanceof Software){
         if(target.getNumOfSoftware()<5){
        //compare new software with those aready exist................................................................................     
                boolean isThere=searchSoftwareExists(target,(Software)myDevice);      
        //if software is not installed befor ............................................................................................
              if(!isThere) {
              target.addSoftware((Software)myDevice);
              write1.println("The S/W "+((Software)myDevice).getName()+" has been installed in the The computer "
              +"Company : "+target.getCompany()+" Model: "+target.getModelName());}
        //if software is installed befor ................................................................................................      
              else{write1.println("The computer Company : "+target.getCompany()+" Model: "+target.getModelName());
               write1.println("has already S/W "+((Software)myDevice).getName()+"installed..");} }
        //when number of software reach 5     
             else{write1.println("The computer Company : "+target.getCompany()+" Model: "+target.getModelName());
               write1.println("has 5 S/W installed.. You can not install any S/W");}
          }
         //*Mice*//.......................................................................................................................
                else if(myDevice instanceof Mouse){
                Mouse device =(Mouse)myDevice;
                if(target.getMouse()!=null&&target.getMouse().getDevice_code().equals(dev)){
                     write1.println("The computer Company : "+target.getCompany()+" Model: "+target.getModelName());
                     write1.println("has already attached to Mouse"+device.getCompany() +" "+device.getType());}
            
                else{target.setMouse(device);
                     write1.println("The Mouse "+device.getCompany()+" "+device.getType()
                     +" has been attached to The computer Company : "+target.getCompany()+" Model: "+target.getModelName());}}
            
         //*printers*//.......................................................................................................................
            else if (myDevice instanceof Printer ){
                    Printer device =(Printer)myDevice;
                    if(target.getPrinter()!=null&&target.getPrinter().getDevice_code().equals(dev)){
                     write1.println("The computer Company : "+target.getCompany()+" Model: "+target.getModelName());
                     write1.println("has already attached to Printer"+device.getCompany()+"Printer Type :"
                     + device.getType());}
            
                     else{target.setPrinter(device);
                     write1.println("The Printer "+device.getCompany()+" Printer Type :"+device.getType()
                     +" has been attached to The computer Company : "+target.getCompany()+" Model: "+target.getModelName());}}
}


///////////////////////////////////////////////////////////////////////////////////////////////////////
public static boolean searchSoftwareExists(Computer target,Software software){
boolean isThere=false; 
 for (int k=0 ; k<target.getNumOfSoftware();k++){ 
   if(target.getSoftware().get(k).equals(software)){
   return true;}}
 return isThere;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
public static Computer searchComputer(String c){
  Computer target=null;
  for(int i = 0 ;i<All_devices.size();i++){
  if (All_devices.get(i)instanceof Computer && All_devices.get(i).getDevice_code().equals(c)){
  target =(Computer)All_devices.get(i);}}

return target;    
}

////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void UnInstall(Scanner read,ArrayList<Device>All_devices,PrintWriter write1){
    String computer = read.next(); String device=read.next();Computer target=null;
//search for computer...................................................................        
    target= searchComputer(computer);
//search for software .................................................................
    for(int j = 0 ;j<All_devices.size();j++){
    if (All_devices.get(j)instanceof Software && All_devices.get(j).getDevice_code().equals(device)){
//compare new software with those aready exist........................................
    boolean isThere=searchSoftwareExists(target,(Software)All_devices.get(j));
//if software not installed befor .....................................................
    if(isThere) {
    target.removeSoftware((Software)All_devices.get(j));
    write1.println("The S/W "+((Software)All_devices.get(j)).getCompany()+" has been Uninstalled in the The computer "
    +"Company : "+target.getCompany()+" Model: "+target.getModelName());}
              
    else{write1.println("The Software :"+((Software)All_devices.get(j)).getCompany()+
    " is not installed\nin  The computer  Company : "+target.getCompany()+" Model: "+target.getModelName());
       } } } 
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void printComputersDetails(PrintWriter write,Computer computer){
//print computer details...................................................................
 write.println(computer.toString());
 //print softwares in the computer.........................................................
 write.println("-- Following Softwares are Installed in the Machine ---");
if(computer.getNumOfSoftware()==0){
 write.println(" No Software has been installed");}
 else{ 
 for(int i = 0;i<computer.getNumOfSoftware();i++){
 write.println();      
 write.println(computer.getSoftware().get(i));
 write.println();  
 }}
 //print device attached to the computer....................................................
 write.println("--- Following  Peripheral are  attached in the Machine ---");
 if(computer.getMouse()==null&&computer.getPrinter()==null){
 write.println(" No Pripheral has been attached");}
 else{ write.println();
 if(computer.getMouse()!=null){
 write.println(computer.getMouse());
 write.println("\n");}
   
 if(computer.getPrinter()!=null){
 write.println(computer.getPrinter());
 write.println("\n");
   } }}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void end(PrintWriter write){
         write.println(); 
         write.println(" has been added to the FCIT Lab. Database.");
         write.println();
       
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void format(PrintWriter write,String command){
      write.println();
      write.println("**************************************************************************************************************");
      write.println("Command: "+command);
      write.println();
    
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void Print_Device_Details(PrintWriter write1,Device device){
    if(device instanceof Printer)
    write1.println(((Printer)device));
    else if(device instanceof Mouse)
    write1.println(((Mouse)device));
    else{write1.println(((Software)device));}
    end(write1);}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}





    
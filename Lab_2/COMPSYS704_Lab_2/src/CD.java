import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import guicreate.ConveyorVisual;//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 1, column: 1
import fibonacci.FibonacciGenerator;//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 2, column: 1

public class CD extends ClockDomain{
  public CD(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  private Signal A_1;
  private ConveyorVisual guiObj_thread_2;//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 10, column: 3
  private int S24 = 1;
  private int S20 = 1;
  private int S3 = 1;
  private int S2 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread30(int [] tdone, int [] ends){
        active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread29(int [] tdone, int [] ends){
        switch(S20){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S3){
          case 0 : 
            switch(S2){
              case 0 : 
                S3=0;
                if(A_1.getprestatus()){//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 15, column: 13
                  S2=0;
                  System.out.println("Got a");//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 16, column: 6
                  ends[2]=2;
                  S3=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S2=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S2=1;
                S3=0;
                if(A_1.getprestatus()){//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 15, column: 13
                  S2=0;
                  System.out.println("Got a");//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 16, column: 6
                  ends[2]=2;
                  S3=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S2=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread27(int [] tdone, int [] ends){
        A_1.setPresent();//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 31, column: 3
    currsigs.addElement(A_1);
    System.out.println("Emitted A_1");
    active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread26(int [] tdone, int [] ends){
        S20=1;
    guiObj_thread_2 = new ConveyorVisual();//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 10, column: 3
    S3=0;
    if(A_1.getprestatus()){//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 15, column: 13
      S2=0;
      System.out.println("Got a");//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 16, column: 6
      ends[2]=2;
      S3=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      S2=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S24){
        case 0 : 
          S24=0;
          break RUN;
        
        case 1 : 
          S24=2;
          S24=2;
          A_1.setClear();//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 6, column: 2
          thread26(tdone,ends);
          thread27(tdone,ends);
          int biggest28 = 0;
          if(ends[2]>=biggest28){
            biggest28=ends[2];
          }
          if(ends[3]>=biggest28){
            biggest28=ends[3];
          }
          if(biggest28 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          A_1.setClear();//C:\Users\beckb\Documents\GitHub\CS704-Work\Lab_2\COMPSYS704_Lab_2\sysj\Exercise2.sysj line: 6, column: 2
          thread29(tdone,ends);
          thread30(tdone,ends);
          int biggest31 = 0;
          if(ends[2]>=biggest31){
            biggest31=ends[2];
          }
          if(ends[3]>=biggest31){
            biggest31=ends[3];
          }
          if(biggest31 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest31 == 0){
            S24=0;
            active[1]=0;
            ends[1]=0;
            S24=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    A_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          df = true;
        }
        runClockDomain();
      }
      A_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      A_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}

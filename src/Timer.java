import java.text.DecimalFormat;
import java.util.Scanner;

public class Timer extends Thread{
    private int size;
    private int time;
    public Timer(int size){
        this.size=size;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size=size;
    }
    public int getTime(){
        return time;
    }
    public void setTime(int time){
        this.time=time;
    }
    public void increase(){
        time++;
        if(time==size){
            time=0;
        }
    }
}

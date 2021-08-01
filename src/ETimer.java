public class ETimer extends Thread{
    Timer hour=new Timer(24);
    Timer minute=new Timer(60);
    Timer second=new Timer(60);
    //构造器构造当前时间
    public ETimer(int hour, int minute, int second) {
        this.hour.setTime(hour);
        this.minute.setTime(minute);
        this.second.setTime(second);
    }


    //多线程控制时间变化
    public void Etime(){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    try{
                        sleep(1000);
                        second.increase();//秒针
                        if(second.getTime()==0){
                            //分钟加一
                            minute.increase();
                            if(minute.getTime()==0){
                                //时钟加一
                                hour.increase();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        thread.start();
    }
    //线程控制每秒输出
    public void getTime(){
       Thread thread1=new Thread(new Runnable(){
           @Override
           public void run(){
               try{
                   while(true){
                       sleep(1000);//暂停一秒
                       System.out.printf("%d:%d:%d ",hour.getTime(),minute.getTime(),second.getTime());
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });
       thread1.start();
    }

}

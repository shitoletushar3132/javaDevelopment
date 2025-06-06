class Run1 extends Thread {
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("hii");
        }
    }
}

class Run2 extends Thread{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("helo");
        }
    }
}


public class MultiThread {
    public static void main(String [] a){
            Run1 hii = new Run1();
            Run2 helo = new Run2();

            hii.start();
            helo.start();
    }
}

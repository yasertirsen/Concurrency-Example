class Foo {
    private boolean ex1, ex2 =false;
    public Foo() {
       
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        ex1= true;
        this.notifyAll();
    }
    

    public synchronized void second(Runnable printSecond) throws InterruptedException {
       while (!ex1){
            this.wait();
        }
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run(); 
        this.ex2 = true;
        this.notifyAll();
    }

    public synchronized  void third(Runnable printThird) throws InterruptedException {
        while (!ex2){
            wait();
        }
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        this.notifyAll();
    }
    
    
}

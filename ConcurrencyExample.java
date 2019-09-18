class Foo {
    private boolean ex1, ex2;
    public Foo() {
       
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        ex1= true;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }
    

    public synchronized void second(Runnable printSecond) throws InterruptedException {
       while (!ex1){
            wait();
        }
        ex2 = true;
        notifyAll();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run(); 
    }

    public synchronized  void third(Runnable printThird) throws InterruptedException {
        while (!ex2){
            wait();
        }
        notifyAll();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
    
    
}
package oop;

public abstract class BaseClass {
    public BaseClass (int a){
        System.out.println("BaseClass Constructor");
    }

    public abstract void doHdml();

    // final
    public void IsIVirtual(){
        System.out.println("BaseClass IsIVirtual");
    }
}

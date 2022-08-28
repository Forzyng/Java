package oop;

public class ChildrenClass
        extends BaseClass // Классы насследуются
        implements  // Реализовываются
        Runnable

{
    @Override
    public void doHdml() {}

    @Override
    public void run() {}

    public ChildrenClass(){
        super(2); // Вызов базового конструктора (конструктора предка)
        System.out.println("BaseClass Constructor");
    }


    @Override
    public void IsIVirtual(){
        super.IsIVirtual(); // Вызов метода из базового класса (класса предка)
        System.out.println("ChildrenClass IsIVirtual");
    }

}

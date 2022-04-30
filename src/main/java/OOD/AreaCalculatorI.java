package OOD;

interface Shape {
    public float getArea(); //  必须是public，并且不能有具体实现，不能有constructor
}

class Triangle implements Shape {
    //  在这里，我们只需要做三角形的面积计算，不需要别的形状。
    //  L.I原则，子类或者Implementation class实现base class/interface的功能
    public int b;
    public int h;
    public float getArea() {
        return h * b / 2;
    }
}

public class AreaCalculatorI {
    private float result;
    public float getResult() {
        return this.result;
    }
    //  Single responsiblity 不做别的操作，比如打印
    public void calculateArea(Shape s) {    //  实现了DI，不依赖于任何具体的class
        this.result =  s.getArea();
    }
}

class Printer {
    public void printInJson(float number) {
        //  jsonPrinter.initialize();
        //  jsonPrinter.print(this.result);
        //  jsonPrinter.close();
    }
}

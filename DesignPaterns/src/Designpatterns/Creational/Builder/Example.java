package Designpatterns.Creational.Builder;

public class Example {
    private int a;
    private int b;
    private int c;

    private Example() {}
    public void printAll() {
        System.out.println(this.a + " " +  this.b + " " + this.c);
    }

    public static ExampleBuilder getBuilder() {
        return new ExampleBuilder();
    }

    public static class ExampleBuilder {
        private int a;
        private int b;
        private int c;

        public int getA() {
            return a;
        }

        public ExampleBuilder setA(int a) {
            this.a = a;
            return this;
        }

        public int getB() {
            return b;
        }

        public ExampleBuilder setB(int b) {
            this.b = b;
            return this;
        }

        public int getC() {
            return c;
        }

        public ExampleBuilder setC(int c) {
            this.c = c;
            return this;
        }

        public Example build() {
        // validate first then create the object
            if(this.a > 5){
                throw new ArithmeticException("a Can't be > 5");
            }
            Example obj = new Example();
            obj.a = this.a;
            obj.b = this.b;
            obj.c = this.c;

            return obj;
        }
    }
}

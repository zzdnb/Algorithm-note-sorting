package niuke;

public class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value; //10
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value; //10
        }
        public int getValue() {
            try {
                value ++; //11
                return value;
            } finally {
                this.setValue(value); //22
                System.out.println(value);//22
            }
        }
    }
    //只有明确调用了super.XXX方法，或者子类中没有这个方法时，才会去调用父类的方法。
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3); // getValue() = 11  8
        }
        @Override
        public void setValue(int value) { //val = 5
            super.setValue(2 * value);  //10
        }
    }
}
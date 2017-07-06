package exception;

/**
 * Created by hanbing on 2017/7/6.
 */
public class RuntimeExceptionTest {
    public static void main(String[] args) throws ArithmeticException {
        //arithmeticExceptionTest();
        arithmeticAndArrayIndexOutOfBoundsTest();
    }

    //测试ArithmeticException
    public static void arithmeticExceptionTest() {
        int a = 6;
        int b = 0;

        try {
            if (b == 0)
                throw new ArithmeticException();
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("exception! b can not be '0'");
        }
        System.out.println("program quit normally");
    }

    //测试ArithmeticException和ArrayIndexOutOfBoundsException
    public static void arithmeticAndArrayIndexOutOfBoundsTest() {
        int[] intArray = new int[3];
        try {
            for (int i = 0; i <= intArray.length; i++) {
                intArray[i] = i;
                System.out.println("intArray[" + i + "] = " + intArray[i]);
                System.out.println("intArray[" + i + "]模 " + (i - 2) + "的值:  "
                        + intArray[i] % (i - 2));
            }
        }catch(ArithmeticException e){
            System.out.println("not zero");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("too long");
        }
    }

}

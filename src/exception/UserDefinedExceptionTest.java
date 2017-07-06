package exception;

import java.lang.reflect.Method;

/**
 * Created by hanbing on 2017/7/6.
 */
public class UserDefinedExceptionTest {

    static int qoutient(int a, int b) throws MyException{
        if(b < 0){
            throw new MyException("b不能为负数");
        }

        return (a / b);
    }

    public static void main(String[] args){
        int a = 6;
        int b = 0;

        try{
            int c = qoutient(a, b);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }catch(ArithmeticException e){
            System.out.println("除数不能为0");
        }catch(Exception e){
            System.out.println("程序出现了其他异常！");
        }
        Method[] methods = RuntimeExceptionTest.class.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        try {
            Class aClass = Class.forName("RuntimeExceptionTest");
            Class bClass = RuntimeExceptionTest.class;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class MyException extends Exception{
    String message;
    public MyException(String errMessage){
        message = errMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

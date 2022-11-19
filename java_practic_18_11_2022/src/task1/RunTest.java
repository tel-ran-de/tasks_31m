package task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RunTest {

    public static void start(Class obj) {
        getAnnotateAndRun(obj);
    }

    public static void start(String objFullName) {
        try {
            getAnnotateAndRun(Class.forName(objFullName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getAnnotateAndRun(Class testedObj) {
        Method beforeMethod = null;
        Method afterMethod = null;

        // Получим все методы класса
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : testedObj.getDeclaredMethods()) {
            if (method.getDeclaredAnnotation(BeforeSuite.class) != null) {
                if (beforeMethod != null) {
                    throw new RuntimeException("Class has too many beforeSuite annotation");
                }
                beforeMethod = method;
                continue;
            }
            if (method.getDeclaredAnnotation(AfterSuite.class) != null) {
                if (afterMethod != null) {
                    throw new RuntimeException("Class has too many afterSuite annotation");
                }
                afterMethod = method;
                continue;
            }
            if (method.getDeclaredAnnotation(Test.class).order() > 10 ||
                    method.getDeclaredAnnotation(Test.class).order() < 1) {
                throw new RuntimeException("Class has methods with wrong order");
            }
            methods.add(method);
        }
        methods.sort((o1, o2) -> {
            int order1 = o1.getDeclaredAnnotation(Test.class).order();
            int order2 = o2.getDeclaredAnnotation(Test.class).order();
            return Integer.compare(order1, order2);
        });
        if (beforeMethod != null) {
            methods.add(0, beforeMethod);
        }
        if (afterMethod != null) {
            methods.add(afterMethod);
        }

        //Создадим экземпляр класса для запуска методов
        Object obj = null;
        try {
            obj = testedObj.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Запуск методов
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (Method method : methods) {
            System.out.print(sdf.format(Calendar.getInstance().getTime()) +
                " :: Run " + testedObj.getSimpleName() + ". " +
                method.getName() + ": ");
            try {
                method.invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


}

package task1;

public class AnnotatedClass {

    @Test(order = 3)
    public void test3() {
        System.out.println("Test3 run");
    }

    @Test(order = 4)
    public void test4() {
        System.out.println("Test4 run");
    }

    @Test(order = 1)
    public void test1() {
        System.out.println("Test1 run");
    }

    @Test(order = 3)
    public void test31() {
        System.out.println("Test3.1 run");
    }

    @Test
    public void test5() {
        System.out.println("Test5 run");
    }

    @AfterSuite
    public void after() {
        System.out.println("task1.AfterSuite run");
    }

    @BeforeSuite
    public void before() {
        System.out.println("task1.BeforeSuite run");
    }

    @BeforeSuite
    public void before1() {
        System.out.println("BeforeSuite1 run");
    }

}

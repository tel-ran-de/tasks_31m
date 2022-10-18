public class Main {

    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3};
        Stats<Integer> istats = new Stats<>(inums);
        System.out.println(istats.average());

        Double[] dnums = {1.0, 2.0, 3.0};
        Stats<Double> dstats = new Stats<>(dnums);
        System.out.println(dstats.average());

        System.out.println(istats.sameAvg(dstats));
        System.out.println(dstats.sameAvg(istats));
    }

}

// <T extends суперкласс> означает, что параметр типа Т может быть заменен
// только указанным суперклассом или его подклассами
class Stats<T extends Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    //
    public double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    // Определить равенство двух средних значений
    public boolean sameAvg(Stats<?> ob) {
        return average() == ob.average();
    }
}

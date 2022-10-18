public class Main2 {

    public static void main(String[] args) {
        TwoD[] twoD = {new TwoD(0,0), new TwoD(1, 2)};
        Coords<TwoD> twoDCoords = new Coords<>(twoD);

        ThreeD[] threeD = {new ThreeD(1, 2, 3), new ThreeD(4, 5, 6)};
        Coords<ThreeD> threeDCoords = new Coords<>(threeD);

        FourD[] fourD = {new FourD(1, 2, 3, 4), new FourD(5, 6, 7, 8)};
        Coords<FourD> fourDCoords = new Coords<>(fourD);

        showXY(twoDCoords);
        showXY(threeDCoords);
        showXY(fourDCoords);

        // showXYZ(twoDCoords); // Ошибка
        showXYZ(threeDCoords);
        showXYZ(fourDCoords);

        // showXYZT(twoDCoords); // Ошибка
        // showXYZT(threeDCoords); // Ошибка
        showXYZT(fourDCoords);

        // Аналогично может быть установлено ограничение снизу <T super подкласс>
        // означает, что параметр Т может быть заменен указанным подклассом или его
        // суперклассами


    }

    public static void showXY(Coords<?> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    public static void showXYZ(Coords<? extends ThreeD> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
        }
        System.out.println();
    }

    public static void showXYZT(Coords<? extends FourD> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
        }
        System.out.println();
    }

}

class TwoD {
    public int x, y;

    public TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    public int z;

    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    public int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

class Coords<T extends TwoD> {
    T[] coords;

    public Coords(T[] coords) {
        this.coords = coords;
    }
}


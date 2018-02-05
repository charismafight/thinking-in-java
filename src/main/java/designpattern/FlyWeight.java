package designpattern;

import java.util.HashMap;

public class FlyWeight {
    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(1, 3);
        Coordinate c3 = new Coordinate(2, 2);
        Chess whiteChess = ChessFactory.getChess("白色");
        whiteChess.show(c1);
        Chess blackChess = ChessFactory.getChess("黑色");
        whiteChess.show(c2);
        System.out.println(whiteChess);
        blackChess.show(c3);
        Chess anotherWhiteChess = ChessFactory.getChess("白色");
        anotherWhiteChess.show(c2);
        System.out.println(anotherWhiteChess);
    }
}

interface ChessFlyWeight {
    String getColor();

    void setColor(String color);

    void show(Coordinate c);
}

class Chess implements ChessFlyWeight {
    private String color;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void show(Coordinate c) {
        System.out.println("chess color:" + this.color + " at (" + c.getX() + "," + c.getY() + ")");
    }
}

class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class ChessFactory {
    //这里使用hashmap来保证同样的key值数据只保留一份，因为享元的具体类是完全一致的，把不一致的一个数据项作为key刚好达到
    //资源管理的效果，java中String的类使用了享元模式
    private static HashMap<String, Chess> map = new HashMap<>();

    public static Chess getChess(String color) {
        if (!map.containsKey(color)) {
            Chess chess = new Chess();
            chess.setColor(color);
            map.put(color, chess);
            return chess;
        } else {
            return map.get(color);
        }
    }
}
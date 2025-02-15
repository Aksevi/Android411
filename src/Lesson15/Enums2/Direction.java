package Lesson15.Enums2;

import java.util.Random;

// 27 1-42
public enum Direction {
    TOP, RIGHT, LEFT, BOTTOM;

    private static final Random RAND = new Random();

    public static Direction randomDirection(){
        Direction[] directions = values(); // массив
        return directions[RAND.nextInt(directions.length)];
    }
}

import java.util.Arrays;

public class Assignment01Q04 {

    // Shift the array to the left by one position
    private static void shiftOnce(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = first;
    }

    // Translate the move to a positive number of shifts in the correct direction
    private static int translateMove(int move, int length, char direction) {
        if (length == 0) {
            return 0;
        }
        move = move % length;
        
        switch (direction) {
            case 'L':
                return (move < 0? length-Math.abs(move) : move);
            case 'R':
                return (move < 0? -move : length-Math.abs(move));
            default:
                return 0;
        }
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        move = translateMove(move, array.length, direction);

        for (int i = 0; i < move; i++) {
            shiftOnce(array);
        }
        
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}
import java.util.Arrays;

public class Assignment01Q04 {

    // Shift the array to the left by one position
    private static void shiftLeft(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = first;
    }

    // Shift the array to the right by one position
    private static void shiftRight(int[] array) {
        int last = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = last;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        
        if (array.length == 0 || move == 0 || (direction != 'L' && direction != 'R')) {
            return array; // No shift needed
        }

        // Translate negative moves to positive moves in the opposite direction
        long steps = move; // Use long to prevent overflow for Integer.MIN_VALUE
        if (steps < 0) {
            steps = -steps;
            direction = (direction == 'L') ? 'R' : 'L';
        }

        int shifts = (int) (steps % array.length); // Normalize the number of shifts to avoid unnecessary full rotations

        if (direction == 'L') {
            for (int i = 0; i < shifts; i++) {
                shiftLeft(array);
            }
        } else if (direction == 'R') {
            for (int i = 0; i < shifts; i++) {
                shiftRight(array);
            }
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
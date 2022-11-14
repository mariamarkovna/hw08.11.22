package org.example;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        int countOfDisk = 5;
        Stack<Integer> sourceStack = new Stack();
        Stack<Integer> helperStack = new Stack();
        Stack<Integer> destinationStack = new Stack();

        createSourceTower(countOfDisk, sourceStack);
        towerOfHanoiIterative(countOfDisk, sourceStack, helperStack, destinationStack);

    }

    private static void createSourceTower(int countOfDisk, Stack<Integer> source) {
        for (int i = countOfDisk; i >= 1; i--) {
            source.push(i);
        }
    }

    private static void towerOfHanoiIterative(int countOfDisk, Stack<Integer> sourceStack, Stack<Integer> helperStack, Stack<Integer> destinationStack) {
        int moves = (int) (Math.pow(2, countOfDisk)) - 1;
        String source = "source";
        String helper = "helper";
        String destination = "destination";

        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                helperMoveDiskBetweenTwoPoles(sourceStack, destinationStack, source, destination);
            } else if (i % 3 == 2) {
                helperMoveDiskBetweenTwoPoles(sourceStack, helperStack, source, helper);
            } else if (i % 3 == 0) {
                helperMoveDiskBetweenTwoPoles(helperStack, destinationStack, helper, destination);
            }

        }
    }

    private static void helperMoveDiskBetweenTwoPoles(Stack pole, Stack destination, String poleSrc, String poleDest) {
        int sourceTopDisk = pole.empty() ? 0 : (int) pole.pop();
        int destinationTopDisk = destination.empty() ? 0 : (int) destination.pop();

        if (sourceTopDisk == 0) {
            pole.push(destinationTopDisk);
            printMove(destinationTopDisk, poleDest, poleSrc);
        } else if (destinationTopDisk == 0) {
            destination.push(sourceTopDisk);
            printMove(sourceTopDisk, poleSrc, poleDest);
        } else if (sourceTopDisk > destinationTopDisk) {
            pole.push(sourceTopDisk);
            pole.push(destinationTopDisk);

        } else if (sourceTopDisk < destinationTopDisk) {
            destination.push(destinationTopDisk);
            destination.push(sourceTopDisk);
            printMove(sourceTopDisk, poleSrc, poleDest);

        }
    }

    private static void printMove(int disk, String src, String dest) {
        System.out.println("Move the disk" + disk + "from" + src + "to" + dest);
    }

}
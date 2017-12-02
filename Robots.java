/*
	This problem is taken from Algorithm Design by Kleinberg and Tardos, exercise 8 of chapter 6(page 319)

    Problem:
		The residents of the underground city of Zion defend themselves through
		a combination of kung fu, heavy artillery, and efficient algorithms. Recently
		they have become interested in automated methods that can help
		fend off attacks by swarms of robots.
		Here�s what one of these robot attacks looks like.
			A swarm of robots arrives over the course of n seconds; in the i-th
		second, xi robots arrive. Based on remote sensing data, you know
		this sequence x1, x2,..., xn in advance.
		. You have at your disposal an electromagnetic pulse (EMP), which can
		destroy some of the robots as they arrive; the EMP�s power depends
		on how long it's been allowed to charge up. To make this precise,
		there is a function f(�) so that if j seconds have passed since the EMP
		was last used, then it is capable of destroying up to f(j) robots.
		. So specifically, if it is used in the kth second, and it has been j seconds
		since it was previously used, then it will destroy min(xk, f(j)) robots.
		(After this use, it will be completely drained.)
		. We will also assume that the EMP starts off completely drained, so
		if it is used for the first time in the j-th second, then it is capable of
		destroying up to f(j) robots.
			The problem: Given the data on robot arrivals x1, x2,..., xn, and given the
		recharging function f(�), choose the points in time at which you�re going
		to activate the EMP so as to destroy as many robots as possible.

		Example: Suppose n = 4, and the values of xi and f(i) are given by the
		following table.

		  i | 1   2   3   4
		  xi| 1  10  10   1
        f(i)| 1   2   4   8

		The best solution would be to activate the EMP in the 3rd and the 4th
		seconds. In the 3rd second, the EMP has gotten to charge for 3 seconds,
		and so it destroys min(10, 4) = 4 robots; In the 4th second, the EMP has only
		gotten to charge for 1 second since its last use, and it destroys min(1, 1) = 1
		robot. This is a total of 5.

		Give an efficient algorithm that takes the data on robot arrivals
		x1, x2,..., xn, and the recharging function f(�), and returns the maximum
		number of robots that can be destroyed by a sequence of EMP
		activations.
	*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
public class Robots
{
	/*	
		Let opt denote the optimal solution, as well as the name of our memoization table
		I. subproblem. opt(i) = "the number of robots killed on day i to maximize the total number of robots killed"
		II. recurrence. OPT[i] = max{OPT[i-j] + Math.min(function[j], robots[i])}
		III. answer to original question: all OPT[i] i.e. the number of robots killed each day; 
		IV. Base cases: opt(0) = 0. 
						for all i < 0, OPT(i) = 0, there are no negative days. 
		V. implementation: in our implementation, we initialized OPT(0)
	*/
    public static int[] findRobotsKilled(int[] robots, int[] function) // method that decides when to shoot in order to maximize the number of killed robots
    {
        int[] OPT = new int[robots.length]; //OPT is a 1-D array where we save the number of robots killed each day
        OPT[0] = 0;
        for(int i = 1; i < robots.length; i++) {
            int maxOPT = 0;
            for(int j = 2; j <= i; j++) {
                if(OPT[i-j] + Math.min(function[j], robots[i]) > maxOPT) {
                    maxOPT = OPT[i-j] + Math.min(function[j], robots[i]);
                }
            }
            OPT[i] = maxOPT;
        }
        return OPT;
    }
    public static void main(String[] args)
    {
        int[] robots = new int[]{1, 10, 10, 1}; //example: robots coming daily
        int[] function = new int[]{1, 2, 4, 8}; //example: EMP function
        int[] results = findRobotsKilled(robots, function);
        ArrayList<Integer> shootingDays = new ArrayList<Integer>();
        for(int i=0; i<robots.length;i++)
        {
            if(results[i] != 0)
            {
                shootingDays.add(i);
            }
        }
        for(int i=0; i<shootingDays.size() -1;i++)
        {
            System.out.print(shootingDays.get(i)+1 + ", ");
        }
        System.out.print(shootingDays.get(shootingDays.size()-1)+1 + ".");
    }
}
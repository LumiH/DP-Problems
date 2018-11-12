public class Gerrymandering {
	/*
		Gerrymandering is the practice of carving up electoral districts in very
careful ways so as to lead to outcomes that favor a particular political
party. Suppose we have a set of n precincts {P1, P2 ..... Pn} each containing
m registered voters. We’re supposed to divide these precincts into two
districts, each consisting of n/2 of the precincts. Now, for each precinct,
we have information on how many voters are registered to each of two
political parties. (Suppose, for simplicity, that every voter is registered
to one of these two.) We’ll say that the set of precincts is susceptible to
gerrymandering iff it is possible to perform the division into two districts
in such a way that the same party holds a majority in both districts.
Give an algorithm to determine whether a given set of precincts
is susceptible to gerrymandering; the running time of your algorithm
should be polynomial in n and m.
Example. Suppose we have n = 4 precincts, and the following information
on registered voters.
25.
precinct    									1	2	3	4
Num registered for party A   					55  43  60  47
Num registered for party B     					45  57  40  53

This set of precincts is susceptible since, if we grouped precincts 1
and 4 into one district, and precincts 2 and 3 into the other, then party
A would have a majority in both districts. (Presumably, the "we" who are
doing the grouping here are members of party A.) This example is a quick
illustration of the basic unfairness in gerrymandering: Although party A
holds only a slim majority in the overall population (205 to 195), it ends
up with a majority in not one but both districts.
	*/ 
	public static boolean solution(int[][] a) {
		
	}
}
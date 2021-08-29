//package PS5;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Scanner;

public class NinePuzzle2 {

    static ArrayDeque<PuzzleState> toExplore = new ArrayDeque<PuzzleState>();
    static boolean[] visited = new boolean[987654321 + 1];
    static ArrayDeque<PuzzleState> soln = new ArrayDeque<PuzzleState>();

    public static void solve(String s)
    {
        int numberTrips = -1;
        int num = Integer.parseInt(s);
        PuzzleState start = new PuzzleState(s);
        toExplore.addFirst(start);
        visited[num] = true;
        //int n = 0;
        while(!toExplore.isEmpty())
        {
            PuzzleState next = toExplore.removeFirst();
            //next.display();

            if(next.strState.equals("123456789"))
            {
                //System.out.println("Found");
                for (PuzzleState x = next; x != null; x = x.pred) {
                    soln.offerLast(x);
                }
                numberTrips = soln.size()-1;
                System.out.println(numberTrips);
                PuzzleState solution = soln.pollLast();
                while(solution != null) {
                    solution.display();
                    solution= soln.pollLast();
                }
                break;
            }

            next.allPossibilities();

            for(String str : next.possible)
            {
                PuzzleState p = new PuzzleState(str);
                p.pred = next;
                if(p.equiv(p.pred))
                    continue;

                num = Integer.parseInt(str);
                if(visited[num]){
                    continue;
                }

                toExplore.addLast(p);
                visited[num] = true;
            }

        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter: ");
        String input = scanner.nextLine();

        int inv_count = 0;
        for (int i = 0; i < 8; i++)
            for (int j = i+1; j < 9; j++)
                if (input.charAt(i) != '9' && input.charAt(j) != '9' && input.charAt(i)  > input.charAt(j)) {
                    inv_count++;
                    //System.out.println(input.charAt(i) + " > " + input.charAt(j));
                }

        if(inv_count % 2 == 1)
        {
            System.out.println(-1);
            //not solvable
        }
        else {
            //System.out.println(inv_count);
            solve(input);
        }
    }
}

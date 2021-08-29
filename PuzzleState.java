//package PS5;

import java.util.ArrayList;

public class PuzzleState {
    String strState;   //state of the puzzle in String
    ArrayList<String> possible = new ArrayList<String>();
    PuzzleState pred = null;

    PuzzleState(String s)
    {
        strState = s;
    }

    public void allPossibilities()
    {
        int emptySpace = strState.indexOf('9');
        //System.out.println("running " + emptySpace);

        switch(emptySpace)
        {
            case 3:
                possible.add(swap(strState, emptySpace, emptySpace -3));
                possible.add(swap(strState, emptySpace, emptySpace +3));
                possible.add(swap(strState, emptySpace, emptySpace + 1));
                break;

            case 0:
                possible.add(swap(strState, emptySpace, emptySpace + 3));
                possible.add(swap(strState, emptySpace, emptySpace + 1));
                break;
            case 6:
                possible.add(swap(strState, emptySpace, emptySpace -3));
                possible.add(swap(strState, emptySpace, emptySpace + 1));
                break;
            case 2:
                possible.add(swap(strState, emptySpace, emptySpace + 3));
                possible.add(swap(strState, emptySpace, emptySpace - 1));
                break;
            case 5:
                possible.add(swap(strState, emptySpace, emptySpace + 3));
                possible.add(swap(strState, emptySpace, emptySpace - 3));
                possible.add(swap(strState, emptySpace, emptySpace - 1));
                break;
            case 8:
                possible.add(swap(strState, emptySpace, emptySpace - 3));
                possible.add(swap(strState, emptySpace, emptySpace - 1));
                break;

            case 1:
                possible.add(swap(strState, emptySpace, emptySpace + 3));
                possible.add(swap(strState, emptySpace, emptySpace - 1));
                possible.add(swap(strState, emptySpace, emptySpace + 1));
                break;
            case 4:
                possible.add(swap(strState, emptySpace, emptySpace + 3));
                possible.add(swap(strState, emptySpace, emptySpace - 3));
                possible.add(swap(strState, emptySpace, emptySpace - 1));
                possible.add(swap(strState, emptySpace, emptySpace + 1));
                break;
            case 7:
                possible.add(swap(strState, emptySpace, emptySpace - 3));
                possible.add(swap(strState, emptySpace, emptySpace - 1));
                possible.add(swap(strState, emptySpace, emptySpace + 1));
                break;
        }

    }

    public String swap(String str, int i, int j)
    {
        String strCopy = String.valueOf(str);
        char ch[] = strCopy.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        strCopy = new String(ch);
        return strCopy;
    }

    public boolean equiv(PuzzleState other)
    {
        return strState.equals(other.strState);
    }

    public void display()
    {
        System.out.println(strState);
    }


}

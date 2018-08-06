package climbingleaderboard;

import java.util.Arrays;

public class ClimbingLeaderBoard {


    public static int[] getLeaderBoardRankings(final int[] leaderBoardScores, final int[] aliceScores) {

        int[] aliceRanks = new int[aliceScores.length];

        int[] leaderBoardRanks = new int[leaderBoardScores.length];

        int rank = 1;
        int currentScore = leaderBoardScores[0];
        leaderBoardRanks[0] = rank;
        for (int index = 1; index < leaderBoardScores.length; index++) {
            if (leaderBoardScores[index] < currentScore) {
                leaderBoardRanks[index] = ++rank;
            } else if (leaderBoardScores[index] == currentScore) {
                leaderBoardRanks[index] = rank;
            }
            currentScore = leaderBoardScores[index];
        }
        int aliceScoreIndex = 0;
        int index;
        for (index = leaderBoardScores.length - 1; index >= 0 && aliceScoreIndex < aliceScores.length; ) {
            if (aliceScores[aliceScoreIndex] < leaderBoardScores[index]) {
                aliceRanks[aliceScoreIndex] = leaderBoardRanks[index] + 1;
                aliceScoreIndex++;
            } else if (aliceScores[aliceScoreIndex] == leaderBoardScores[index]) {
                aliceRanks[aliceScoreIndex] = leaderBoardRanks[index];
                aliceScoreIndex++;
                index--;
            } else {
                index--;
            }
        }

        while (aliceScoreIndex < aliceScores.length) {
            index = index < 0 ? 0 : index;
            aliceRanks[aliceScoreIndex++] = leaderBoardRanks[index];
        }

        return aliceRanks;
    }

    public static void main(String[] args) {
        int[] leaderBoard = {100, 75, 50, 25};
        int[] aliceRanks = {1, 112};
        System.out.println(Arrays.toString(getLeaderBoardRankings(leaderBoard, aliceRanks)));
    }


}

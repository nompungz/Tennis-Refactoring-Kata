
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    String[] scoreString = {"Love","Fifteen","Thirty","Forty","Deuce"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        //case Love-All and Deuce
        if (m_score1 == m_score2) {
            if (m_score1<3) {
                return String.format("%s-All", scoreString[m_score1]);
            }
            else {
                return scoreString[4];
            }
        //case Advantage and Winner
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1)
                score = "Advantage player1";
            else if (minusResult == -1)
                score = "Advantage player2";
            else if (minusResult >= 2)
                score = "Win for player1";
            else
                score = "Win for player2";
        } else {
                return scoreString[m_score1]+"-"+scoreString[m_score2];
        }
        return score;
    }
}

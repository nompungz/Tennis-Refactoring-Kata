
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    String[] scoreString = {"Love","Fifteen","Thirty","Forty","Deuce","Advantage ","Win for "};

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
            if (IsAdvantage()){
                return Advantage(minusResult);
            }
            else{
                return Winner(minusResult);
            }
        }
        //Case Normal
        return String.format("%s-%s", scoreString[m_score1], scoreString[m_score2]);
    }

    public boolean IsAdvantage() {
        if (Math.abs(m_score1-m_score2) ==1){
            return true;
        }
        return false;
    }
    public String Advantage(int minusResult) {
        if (minusResult == 1){
            return String.format("%s%s",scoreString[5], player1Name);
        }
        return String.format("%s%s",scoreString[5], player2Name);
    }

    public String Winner(int minusResult) {
        if (minusResult >= 2){
            return String.format("%s%s",scoreString[6], player1Name);
        }
        return String.format("%s%s",scoreString[6], player2Name);
    }

}

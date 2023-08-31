package id.ac.petra.quiz;

public class Question {
    private int resId;
    private boolean answer;
    public Question(int textId, boolean theanswer) {
        resId = textId;
        answer = theanswer;
    }
    public int getResId() {
        return resId;
    }
    public void setResId(int textId) {
        resId = textId;
    }
    public boolean getAnswer() {
        return answer;
    }
    public void setAnswer(boolean theanswer) {
        answer = theanswer;
    }

}

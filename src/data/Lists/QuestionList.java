package data.Lists;

import logic.Question;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionList implements Question                      {
    private String question;
    private String[] answers = new String[4];
    private int correctAnswer;

    public QuestionList(int i){
        this.question = QuestionsAnswers.getQuestion(i);

        ArrayList<String> list = new ArrayList<>();
        for(String str: QuestionsAnswers.getAnswers(i)){
            list.add(str);
        }
        Collections.shuffle(list);

        int j = 0;
        String answer = QuestionsAnswers.getCorrectAnswer(i);
        for(String str: list){
            answers[j] = str;
            if(answers[j].equalsIgnoreCase(answer)){
                correctAnswer = j;
            }
            j++;
        }
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String[] getAnswers() {
        return answers;
    }

    @Override
    public boolean isAnswerCorrect(int i) {
        if(correctAnswer == i) {
            return true;
        } else {
            return false;
        }
    }

}

package com.example.akshay.parth;

/**
 * Created by akshay on 13/9/17.
 */

public class questionInfo {

    String question;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    String answer;

    public questionInfo(){
        question = "q";
        choice1 = "q";
        choice2 = "q";
        choice3 = "q";
        choice4 = "q";
        answer = "dsa";
    }

    public questionInfo(String question, String choice1, String choice2, String choice3, String choice4,String answer){
        this.question = question;
        this.answer = answer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4  =choice4;
    }


    public void setAnsweruser(String answer) {
        this.answer = answer;
    }

    public String getChoice1user() {
        return choice1;
    }

    public String getChoice2user() {
        return choice2;
    }

    public String getChoice3user() {
        return choice3;
    }

    public String getChoice4user() {
        return choice4;
    }

    public String getQuestionuser() {
        return question;
    }

    public void setChoice1user(String choice1) {
        this.choice1 = choice1;
    }

    public String getAnsweruser() {
        return answer;
    }

    public void setChoice2user(String choice2) {
        this.choice2 = choice2;
    }

    public void setChoice3user(String choice3) {
        this.choice3 = choice3;
    }

    public void setChoice4user(String choice4) {
        this.choice4 = choice4;
    }

    public void setQuestionuser(String question) {
        this.question = question;
    }
}

package org.vashonsd;

import java.util.HashMap;

public class testScores {
    HashMap<String, Integer> testScores;

    public testScores(HashMap<String, Integer> testScores){
        this.testScores=testScores;
    }

    public HashMap<String, Integer> getTestScores() {
        return testScores;
    }

    public void setTestScores(HashMap<String, Integer> testScores) {
        this.testScores = testScores;
    }

    public void setScore(String name, int score){
        testScores.put(name, score);
    }

    public int getScore(String name){
        return testScores.get(name);
    }

    public int highest(){
        int max=Integer.MIN_VALUE;
        for(int val:testScores.values()){
            if(val>max){
                max=val;
            }
        }
        return max;
    }

    public int lowest(){
        int min=Integer.MAX_VALUE;
        for(int val:testScores.values()){
            if(val<min){
                min=val;
            }
        }
        return min;
    }

    public int average(){
        int ave=0;
        int count=0;
        for(int val:testScores.values()){
            ave+=val;
            count++;
        }
        ave/=count;
        return ave;
    }

    public String toString(){
        String str="";
        for(String key:testScores.keySet()){
            str+=key+": "+testScores.get(key)+", ";
        }
        return str;
    }
}

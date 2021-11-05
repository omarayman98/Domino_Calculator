package com.example.dominocalculator;


import java.util.ArrayList;

public class Player {
    private   int redo;
    private ArrayList<Integer> ScoreList =new ArrayList<>();
    private ArrayList<Integer> RedoList=new ArrayList<>();

    public ArrayList<Integer> getScoreList() {
        return ScoreList;
    }

    public void AddToScoreList(int x){
        if (x!=0){
        if (x>0){
            ScoreList.add(x); }
        else if(x<0){
            if(x<=getScore()&&getScore()>0) {
                ScoreList.add(x);
            } else if(x<=getScore()&&getScore()==0){
            }
            else {
                ScoreList.add(getScore());
            }
        }
            ClearRedoList();
        }
    }

    public int getScore(){
        int y=0;
        for (int i = 0 ;i<ScoreList.size();i++){
            y = y + ScoreList.get(i);
        }
        return y;
    }

    public void ClearRedoList(){
        for (int i=0;i<RedoList.size();i++){
            RedoList.remove(i);
        }
    }

    public ArrayList<Integer> getRedoList() {
        return RedoList;
    }

    public boolean undo(){
        if(ScoreList.size()>0){
            redo = ScoreList.get(ScoreList.size()-1);
            if (redo!=0){ RedoList.add(redo);
            ScoreList.remove(ScoreList.size()-1);
            return true;
            }
    }   return false;
    }
    public boolean redo(){
        if (RedoList.size()>0){
            ScoreList.add(RedoList.get(RedoList.size()-1));
            RedoList.remove(RedoList.size()-1);
            return true;
        } else return false;
    }

}

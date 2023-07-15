package com.unbaiding.scoreassist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends androidx.lifecycle.ViewModel {

    private int aBack,bBack;
    private SavedStateHandle handleA,handleB;

    public MyViewModel(SavedStateHandle handle) {
        this.handleA = handle;
        this.handleB = handle;
    }

    public MutableLiveData<Integer> getaTeamScore(){
        if(!handleA.contains(MainActivity.KEY_NUMBER_A)){
            handleA.set(MainActivity.KEY_NUMBER_A,0);
        }
        return handleA.getLiveData(MainActivity.KEY_NUMBER_A);
    }
    public MutableLiveData<Integer> getbTeamScore(){
        if(!handleB.contains(MainActivity.KEY_NUMBER_B)){
            handleB.set(MainActivity.KEY_NUMBER_B,0);
        }
        return handleB.getLiveData(MainActivity.KEY_NUMBER_B);
    }

    public void AddaTeamScore(int p){
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(getaTeamScore().getValue() + p);
    }

    public void AddbTeamScore(int p){
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getbTeamScore().setValue(getbTeamScore().getValue() + p);
    }

    public void reset(){
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        handleA.set(MainActivity.KEY_NUMBER_A,0);
        handleB.set(MainActivity.KEY_NUMBER_B,0);
    }

    public void undo(){
        handleA.set(MainActivity.KEY_NUMBER_A,aBack);
        handleB.set(MainActivity.KEY_NUMBER_B,bBack);
    }
}

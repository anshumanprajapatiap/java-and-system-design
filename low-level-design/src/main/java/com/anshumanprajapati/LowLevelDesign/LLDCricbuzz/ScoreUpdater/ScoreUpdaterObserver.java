package com.anshumanprajapati.LowLevelDesign.LLDCricbuzz.ScoreUpdater;


import com.anshumanprajapati.LowLevelDesign.LLDCricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}

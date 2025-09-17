package com.anshumanprajapati.LowLevelDesignOnline.LLDCricbuzz.ScoreUpdater;


import com.anshumanprajapati.LowLevelDesignOnline.LLDCricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}

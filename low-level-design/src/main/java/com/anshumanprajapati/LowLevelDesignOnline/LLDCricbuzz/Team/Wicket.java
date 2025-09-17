package com.anshumanprajapati.LowLevelDesignOnline.LLDCricbuzz.Team;

import com.anshumanprajapati.LowLevelDesignOnline.LLDCricbuzz.Inning.BallDetails;
import com.anshumanprajapati.LowLevelDesignOnline.LLDCricbuzz.Inning.OverDetails;
import com.anshumanprajapati.LowLevelDesignOnline.LLDCricbuzz.Team.Player.PlayerDetails;

public class Wicket {

    public WicketType wicketType;
    public PlayerDetails takenBy;
    public OverDetails overDetail;
    public BallDetails ballDetail;

    public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetail, BallDetails ballDetail){

        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }
}

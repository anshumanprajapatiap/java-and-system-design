package com.anshumanprajapati.LowLevelDesign.LLDCricbuzz.Team;

import com.anshumanprajapati.LowLevelDesign.LLDCricbuzz.Inning.BallDetails;
import com.anshumanprajapati.LowLevelDesign.LLDCricbuzz.Inning.OverDetails;
import com.anshumanprajapati.LowLevelDesign.LLDCricbuzz.Team.Player.PlayerDetails;

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

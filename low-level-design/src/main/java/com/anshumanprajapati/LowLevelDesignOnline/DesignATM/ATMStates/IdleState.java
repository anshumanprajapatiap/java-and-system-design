package com.anshumanprajapati.LowLevelDesignOnline.DesignATM.ATMStates;

import com.anshumanprajapati.LowLevelDesignOnline.DesignATM.ATM;
import com.anshumanprajapati.LowLevelDesignOnline.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}

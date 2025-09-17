package com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.User;
import com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.UserExpenseBalanceSheet;

public class User {

    String userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String userName){
        this.userId = id;
        this.userName = userName;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }
    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }
}

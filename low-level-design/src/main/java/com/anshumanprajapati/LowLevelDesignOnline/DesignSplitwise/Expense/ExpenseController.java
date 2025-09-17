package com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.Expense;

import com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.BalanceSheetController;
import com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.Expense.Split.ExpenseSplit;
import com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.Expense.Split.Split;
import com.anshumanprajapati.LowLevelDesignOnline.DesignSplitwise.User.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}

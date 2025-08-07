package com.anshumanprajapati.LowLevelDesign.DesignSplitwise.Expense;

import com.anshumanprajapati.LowLevelDesign.DesignSplitwise.Expense.Split.EqualExpenseSplit;
import com.anshumanprajapati.LowLevelDesign.DesignSplitwise.Expense.Split.ExpenseSplit;
import com.anshumanprajapati.LowLevelDesign.DesignSplitwise.Expense.Split.PercentageExpenseSplit;
import com.anshumanprajapati.LowLevelDesign.DesignSplitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}

package com.anshumanprajapati.problem.urlShort.factory;

import com.anshumanprajapati.problem.urlShort.strategy.Base62;
import com.anshumanprajapati.problem.urlShort.strategy.Strategy;

public class StrategyFactory {


    public Strategy getStrategy(String strategy){

        switch (strategy){
            case "BASE62":
                return new Base62();
            default:
                return new Base62();
        }
    }

}

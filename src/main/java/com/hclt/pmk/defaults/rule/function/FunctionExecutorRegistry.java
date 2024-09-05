package com.hclt.pmk.defaults.rule.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FunctionExecutorRegistry {

    @Autowired
    private List<FunctionExecutor> functionExecutors;

    public FunctionExecutor getExecutor(String functionType) {
        return functionExecutors.stream().filter( f -> f.getFunctionType().equalsIgnoreCase(functionType)).findFirst().orElse(null);
    }
}

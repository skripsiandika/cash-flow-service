package id.ac.upiyai.cashflowservice.preparation.algorithms;

import java.util.Map;

public interface Distance {
    double calculate(Map<String, Double> f1, Map<String, Double> f2);
}

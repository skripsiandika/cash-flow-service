package id.ac.upiyai.cashflowservice.preparation.algorithms;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class Record {
    private final String description;
    private final Map<String, Double> features;
}

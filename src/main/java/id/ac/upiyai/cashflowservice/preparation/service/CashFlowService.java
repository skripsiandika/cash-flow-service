package id.ac.upiyai.cashflowservice.preparation.service;

import id.ac.upiyai.cashflowservice.preparation.repository.CashFlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashFlowService {

    private final CashFlowRepository repository;
}

package id.ac.upiyai.cashflowservice.disbursement.service;

import id.ac.upiyai.cashflowservice.disbursement.repository.DisbursementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisbursementService {

    private final DisbursementRepository repository;
}

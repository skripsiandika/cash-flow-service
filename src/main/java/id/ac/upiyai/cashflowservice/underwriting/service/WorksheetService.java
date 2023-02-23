package id.ac.upiyai.cashflowservice.underwriting.service;

import id.ac.upiyai.cashflowservice.underwriting.repository.WorksheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorksheetService {

    private final WorksheetRepository repository;
}

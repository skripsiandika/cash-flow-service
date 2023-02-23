package id.ac.upiyai.cashflowservice.approval.service;

import id.ac.upiyai.cashflowservice.approval.repository.ApprovalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApprovalService {

    private final ApprovalRepository repository;
}

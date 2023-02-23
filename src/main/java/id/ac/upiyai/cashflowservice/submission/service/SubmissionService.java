package id.ac.upiyai.cashflowservice.submission.service;

import id.ac.upiyai.cashflowservice.submission.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository repository;
}

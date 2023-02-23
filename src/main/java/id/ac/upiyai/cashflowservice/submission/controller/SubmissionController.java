package id.ac.upiyai.cashflowservice.submission.controller;

import id.ac.upiyai.cashflowservice.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService service;
}

package id.ac.upiyai.cashflowservice.disbursement.controller;

import id.ac.upiyai.cashflowservice.disbursement.service.DisbursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DisbursementController {

    private final DisbursementService service;
}

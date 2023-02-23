package id.ac.upiyai.cashflowservice.preparation.controller;

import id.ac.upiyai.cashflowservice.preparation.service.CashFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cash-flow")
@RequiredArgsConstructor
public class CashFlowController {

    private final CashFlowService service;
}

package id.ac.upiyai.cashflowservice.approval.controller;

import id.ac.upiyai.cashflowservice.approval.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService service;
}

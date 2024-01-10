package ie.atu.projectuserservice;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-service", url = "http://localhost:8083")
@Component
public interface BankServiceClient{
    @PostMapping("/api/transaction/initfunds")
    String createBank(@RequestBody Bank bank);
}

package com.joaogabriel.cotacao_moedas.resources;

import java.math.BigDecimal;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cotacao")
public class CotacaoResource {

    @GetMapping("/convert")
    public ResponseEntity<?> conversao(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount
    ) {
        try {
            String fromUpper = from.toUpperCase();
            String toUpper = to.toUpperCase();

            String url = "https://api.frankfurter.app/latest?from=" + fromUpper + "&to=" + toUpper;

            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> result = restTemplate.getForObject(url, Map.class);

            Map<String, Object> rates = (Map<String, Object>) result.get("rates");
            BigDecimal rate = new BigDecimal(rates.get(toUpper).toString());
            BigDecimal converted = amount.multiply(rate);

            return ResponseEntity.ok(Map.of(
                    "from", fromUpper,
                    "to", toUpper,
                    "amount", amount,
                    "rate", rate,
                    "result", converted
            ));

        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("erro", e.getMessage()));
        }
    }
}
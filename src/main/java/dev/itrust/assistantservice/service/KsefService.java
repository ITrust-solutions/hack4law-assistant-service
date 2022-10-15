package dev.itrust.assistantservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KsefService {

    RestTemplate restTemplate = new RestTemplate();

    public byte[] getInvoiceXml(String invoiceNumber) {
        String ksefApi = "https://hack4law-assistant-ksef.wittysea-0637102a.westeurope.azurecontainerapps.io/invoice/";
        ksefApi = ksefApi + invoiceNumber;
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("hack4law", "d95DaH34jcoP");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(ksefApi, HttpMethod.GET, entity, byte[].class).getBody();
    }
}

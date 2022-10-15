package dev.itrust.assistantservice.controller;

import dev.itrust.assistantservice.hack4law_assistant_service.api.KseFApi;
import dev.itrust.assistantservice.service.KsefService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class KsefController implements KseFApi {

    private final KsefService ksefService;


    @Override
    public ResponseEntity<Resource> fetchKsefInvoice(String invoiceNumber) {
        return prepareResponse(ksefService.getInvoiceXml(invoiceNumber));
    }

    private ResponseEntity<Resource> prepareResponse(byte[] ksefData) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode("Faktura.xml", StandardCharsets.UTF_8) + "\"")
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(ksefData));
    }
}

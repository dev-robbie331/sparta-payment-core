package com.sparta.paymentcore.infra;

import com.sparta.paymentcore.dto.PortOneConfigResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PortOneConfigController {

    private final PortOneProperties portOneProperties;

    @GetMapping("/api/config/portone")
    public ResponseEntity<PortOneConfigResponse> getConfig() {
        return ResponseEntity.ok(new PortOneConfigResponse(
                portOneProperties.getStoreId(),
                portOneProperties.getChannelKey()
        ));
    }

}

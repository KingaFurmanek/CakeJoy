package org.cakejoy.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders/decorations")
@RequiredArgsConstructor
public class DecorationsOrderController {

//    private final DecorationService decorationService;
//    private final DecorationsMapper decorationsMapper;
//
//    @GetMapping("/{orderId}")
//    public Set<DecorationDTO> getDecorationsForOrder(@PathVariable Integer orderId) {
//        Set<DecorationDTO> decorationsDTO = decorationService.getDecorationsForOrder(orderId)
//                .stream()
//                .map(decorationsMapper::toDecorationDTO)
//                .collect(Collectors.toSet());
//        return decorationsDTO;
//    }
//
//    @PostMapping("/{orderId}")
//    public ResponseEntity<ResponseDTO> addDecorationToOrder(@PathVariable Integer orderId, @RequestBody Set<DecorationDTO> decorationsDTO) {
//        return null;
//    }
}

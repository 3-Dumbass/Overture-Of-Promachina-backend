package com.oops.OvertureOfPromachina.application.controller.casinoChip;


import com.oops.OvertureOfPromachina.application.controller.casinoChip.dto.ChipDto;
import com.oops.OvertureOfPromachina.application.entity.casinoChip.CasinoChip;
import com.oops.OvertureOfPromachina.application.service.business.CasinoChip.CasinoChipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Chip api", description = "칩 교환 api")
@RestController
@RequestMapping("/api/chip")
@RequiredArgsConstructor
public class CasinoChipController {

    private final CasinoChipService casinoChipService;

    /** 보유 머니 변동 결과 반환 */
    @Operation(summary = "chip trade api", description = "보유 칩 업데이트 api")
    @PostMapping("/update")
    public ResponseEntity<Boolean> chipUpdate(@RequestBody @Valid ChipDto chipDto) {

        CasinoChip casinoChip_data = casinoChipService.chipUpdate(chipDto);

        return ResponseEntity.ok()
                .body(casinoChip_data != null);
    }

    /** 보유 머니 반환 */
    @Operation(summary = "chip money api", description = "보유 칩 현황 api")
    @PostMapping("/return")
    public ResponseEntity<ChipDto> chipReturn(@RequestBody @Valid ChipDto chipDto) {

        Long money = casinoChipService.chipReturn(chipDto);
        chipDto.setMoney(money);

        return ResponseEntity.ok()
                .body(chipDto);
    }

}

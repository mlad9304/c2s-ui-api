package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PcmFlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.service.PcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pcm/patients")
public class PcmRestController {

    @Autowired
    private PcmService pcmService;

    @GetMapping("/providers")
    public List<PcmFlattenedSmallProviderDto> getProviders() {
        return pcmService.getProviders();
    }

    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProviders(@Valid @RequestBody IdentifiersDto providerIdentifiersDto) {
        pcmService.saveProviders(providerIdentifiersDto);
    }

    @DeleteMapping("/providers/{providerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProvider(@PathVariable Long providerId) {
        pcmService.deleteProvider(providerId);
    }
}
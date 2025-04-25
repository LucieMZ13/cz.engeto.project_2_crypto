package cz.engeto.project_2_crypto.demo.controller;

import cz.engeto.project_2_crypto.demo.model.Crypto;
import cz.engeto.project_2_crypto.demo.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cryptos")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @PostMapping
    public void addCrypto (@RequestBody Crypto crypto) {
        cryptoService.addNewCrypto(crypto);
    }

    @GetMapping
    public List<Crypto> sortByParam(
            @RequestParam(value = "sort", required = false) String sortingParam
    ) { if (sortingParam != null) {
        return cryptoService.sortBy(sortingParam);
    }
        else {
            return cryptoService.getCryptoList();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crypto> getDetailWithID(
            @PathVariable int id
    ) {
        Optional<Crypto> crypto = cryptoService.getCryptoByID(id);
        return crypto.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }
}

package cz.engeto.project_2_crypto.demo.service;

import cz.engeto.project_2_crypto.demo.model.Crypto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CryptoService {
    private List<Crypto> cryptoList = new ArrayList<>(
            List.of(
                    new Crypto(11, "Starmer", "sta",
                            20.5, 18),
                    new Crypto(22, "Sunak", "sun",
                            12.6, 120),
                    new Crypto(33, "May", "ma",
                            16.5, 150)
            )
    );

    public CryptoService(List<Crypto> cryptoList) {
        this.cryptoList = cryptoList;
    }

    public CryptoService() {
    }

    public void addNewCrypto(Crypto crypto) {
        cryptoList.add(crypto);
    }

    public void removeCrypto(int index) {
        cryptoList.remove(index);
    }

    public List<Crypto> getCryptoList() {
        return cryptoList;
    }

    public void setCryptoList(List<Crypto> cryptoList) {
        this.cryptoList = cryptoList;
    }

    public Optional<Crypto> getCryptoByID(int id) {
        return cryptoList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public List<Crypto> sortBy(String param) {
        return switch (param.toLowerCase()) {
            case "name" -> cryptoList.stream()
                    .sorted(Comparator.comparing(Crypto::getName))
                    .collect(Collectors.toList());
            case "price" -> cryptoList.stream()
                    .sorted(Comparator.comparingDouble(Crypto::getPrice))
                    .collect(Collectors.toList());
            case "quantity" -> cryptoList.stream()
                    .sorted(Comparator.comparingDouble(Crypto::getQuantity))
                    .collect(Collectors.toList());
            default -> cryptoList;
        };
    }
}


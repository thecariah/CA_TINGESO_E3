package cl.tingeso.calculoNotasservice.services;

import cl.tingeso.calculoNotasservice.repositories.CalculoNotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculoNotasService {
    @Autowired
    private CalculoNotasRepository calculoNotasRepository;

    @Autowired
    RestTemplate restTemplate;
}

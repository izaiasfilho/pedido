package com.produto.pedido.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.produto.pedido.models.Cep;

@Service
public class LocalizadorCEPService {

    private final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    private final RestTemplate restTemplate;

    public LocalizadorCEPService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Cep buscarEnderecoPorCEP(String cep) {
        String url = VIA_CEP_URL + cep + "/json";
        return restTemplate.getForObject(url, Cep.class);
    }
}
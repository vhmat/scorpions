package br.com.univesp.pi.scorpions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapaController {

    @GetMapping("/heatmap")
    public String exibirMapa() {
        return "heatmap";
    }
}
package com.alucar.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncaoController {

    @GetMapping("/admin")
    public String admin() {
        return "<h2>Admin</h2>";
    }

    @GetMapping("/usuario")
    public String user() {
        return "<h2>Usuário</h2>";
    }

    @GetMapping("/anonimo")
    public String anonimo() {
        return "<h2>Anônimo</h2";
    }
}

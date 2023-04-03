package br.com.fase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fase3.util.VersionComponent;
import br.com.fase3.util.StatusComponent;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    private final VersionComponent versionComponent;
    private final StatusComponent statusComponent;

    public HealthCheckController(
        @Autowired VersionComponent versionComponent, 
        @Autowired StatusComponent statusComponent
    ) {
        System.out.println("Controller constructor");
        System.out.println("versionComponent:" + versionComponent.getVersion());
        System.out.println("statusComponent:" + statusComponent.getStatus());
        this.versionComponent = versionComponent;
        this.statusComponent = statusComponent;
    }

    @GetMapping
    public ResponseEntity<String> status() { return ResponseEntity.ok(this.statusComponent.getStatus()); }

    @GetMapping("version")
    public ResponseEntity<String> version() { return ResponseEntity.ok(this.versionComponent.getVersion()); }

}

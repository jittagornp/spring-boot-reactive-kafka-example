package me.jittagornp.example.reactive.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class RegisterRequest implements Serializable {

    private UUID id;

    private String email;
}

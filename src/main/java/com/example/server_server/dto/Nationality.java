package com.example.server_server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class Nationality {
    private String country_id;
    private double probability;
}   
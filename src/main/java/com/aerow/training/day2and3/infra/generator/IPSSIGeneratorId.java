package com.aerow.training.day2and3.infra.generator;

import com.aerow.training.day2.example.core.usecase.service.IdGenerator;

public class IPSSIGeneratorId implements IdGenerator {
    @Override
    public String generateId() {
        return "IPSSI-";
    }
}

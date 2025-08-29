package com.aerow.training.day2and3.infra.generator;


import com.aerow.training.day2and3.core.usecase.service.IdGenerator;

import java.util.UUID;
import java.util.function.Supplier;

public class IPSSIGeneratorId implements IdGenerator {

    private final Supplier<String> idSupplier;

    public IPSSIGeneratorId() {
        idSupplier = () -> UUID.randomUUID().toString(); // glue
    }

    IPSSIGeneratorId(Supplier<String> idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Override
    public String generateId() {
        assert idSupplier != null;
        return idSupplier.get();
    }
}

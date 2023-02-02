package com.reynaldohendson.rhlog.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientIdInput {
    @NotNull
    private Long id;
}

package com.reynaldohendson.rhlog.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ErrorApi {
    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
    @AllArgsConstructor
    @Getter
    public static class Campo{
        private String nome;
        private String mensagem;
    }
}

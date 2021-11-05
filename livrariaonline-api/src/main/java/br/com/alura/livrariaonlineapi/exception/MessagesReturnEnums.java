package br.com.alura.livrariaonlineapi.exception;

import lombok.Getter;

@Getter
public enum MessagesReturnEnums {

    L010001I("I00001", "Gerando Token");

    private String cod;
    private String message;

    MessagesReturnEnums(String cod, String message) {
        this.cod = cod;
        this.message = message;
    }

    private void DescriptionAndCod(String cod, String message){
        this.getCod();
        this.getMessage();

    }
}

package br.com.alura.livrariaonlineapi.exception;

import br.com.alura.livrariaonlineapi.dto.Erro400DTO;
import br.com.alura.livrariaonlineapi.dto.Erro500DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<Erro400DTO> tratarErro400(MethodArgumentNotValidException exception){

        return exception
                .getFieldErrors()
                .stream()
                .map(erro -> new Erro400DTO(erro.getField(), erro.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Erro500DTO tratarErro500(Exception ex, HttpServletRequest req){

        return new Erro500DTO(
                LocalDateTime.now(),
                ex.getClass().toString(),
                ex.getMessage(),
                null);
    }

}

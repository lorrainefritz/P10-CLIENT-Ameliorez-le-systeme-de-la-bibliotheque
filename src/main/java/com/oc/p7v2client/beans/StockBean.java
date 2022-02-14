package com.oc.p7v2client.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class StockBean {

    private Integer id;

    private int numberOfCopiesAvailable;

    private int numberOfCopiesOut;

    @Min(value=0, message="doit ête compris entre 1 et 10")
    @Max(value=10, message="doit ête compris entre 1 et 10")
    @NotNull(message="Ce champ ne doit pas être vide")
    private int totalOfCopies;

    private boolean bookIsAvailable;


}

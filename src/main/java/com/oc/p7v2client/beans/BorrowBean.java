package com.oc.p7v2client.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class BorrowBean {
    private Integer id;
    private Date startDate;
    private Date returnDate;
    private String username;
    private boolean alreadyExtended;
    private boolean isOutdated;
    private String bookTitle;
    private String bookAuthor;
}

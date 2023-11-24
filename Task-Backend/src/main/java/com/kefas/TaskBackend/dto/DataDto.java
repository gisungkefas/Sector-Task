package com.kefas.TaskBackend.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain letters")
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Sectors should only contain letters")
    private String sectors;

    private boolean agreeTerms;


}

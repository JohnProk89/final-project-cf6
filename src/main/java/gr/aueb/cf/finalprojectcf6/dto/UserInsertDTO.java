package gr.aueb.cf.finalprojectcf6.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserInsertDTO {

    @NotNull
    private String username;

    @NotEmpty
    private String password;
}

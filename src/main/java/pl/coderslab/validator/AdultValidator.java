package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {


    @Override
    public void initialize(Adult adult) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate currentDate = LocalDate.now();

        return localDate.plusYears(18).isBefore( currentDate );

    }
}

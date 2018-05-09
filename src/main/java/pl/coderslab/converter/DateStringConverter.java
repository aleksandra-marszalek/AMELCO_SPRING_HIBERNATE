package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.AuthorDao;

import java.time.LocalDate;

public class DateStringConverter implements Converter<String, LocalDate> {



    @Autowired

    AuthorDao authorDao;



    @Override

    public LocalDate convert(String s) {

        return  LocalDate.parse(s);

    }

}
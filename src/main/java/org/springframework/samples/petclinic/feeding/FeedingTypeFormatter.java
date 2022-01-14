package org.springframework.samples.petclinic.feeding;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class FeedingTypeFormatter implements Formatter<FeedingType>{

    @Autowired 
    FeedingService feedingService;

    @Override
    public String print(FeedingType object, Locale locale) {

        return object.getName();
    }

    @Override
    public FeedingType parse(String text, Locale locale) throws ParseException {

        for (FeedingType ft : this.feedingService.getAllFeedingTypes()){
            if(ft.getName().equals(text))
                return ft;
        }
        throw new ParseException("This is not a product type", 0);

    }
    
}

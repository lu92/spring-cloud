package quoteservice.quoteservicedemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class QuoteServicedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoteServicedemoApplication.class, args);
    }
}


@RestController
class QuoteController {

    private Map<Integer, Quote> quoteMap;

    public QuoteController() {
        quoteMap = new HashMap<>();
        quoteMap.put(1, new Quote("one"));
        quoteMap.put(2, new Quote("two"));
        quoteMap.put(3, new Quote("three"));
        quoteMap.put(4, new Quote("four"));
        quoteMap.put(5, new Quote("fife"));
        quoteMap.put(6, new Quote("six"));
        quoteMap.put(7, new Quote("seven"));
    }

    @GetMapping(value = "/quote")
    @ResponseBody
    Quote getQuote() {
        return quoteMap.get(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Quote {
    private String message;
}
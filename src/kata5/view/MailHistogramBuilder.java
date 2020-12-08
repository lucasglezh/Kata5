package kata5.view;

import java.util.List;
import kata5.model.Histogram;

public class MailHistogramBuilder {

    public static Histogram<String> build(List<String> mailList) {
        Histogram<String> histogram = new Histogram();
        for (String mail : mailList) {
            histogram.increment(mail);
        }
        return histogram;
    }

}

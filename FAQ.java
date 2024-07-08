import java.util.ArrayList;
import java.util.List;

public class FAQ {
    private List<QuestionAnswer> faqs = new ArrayList<>();

    public FAQ() {
        // Load initial FAQs (This could be from a file or database in a real application)
        faqs.add(new QuestionAnswer("What is the difference between weather and climate?", "Weather refers to the day-to-day state of the atmosphere such as the combination of temperature, humidity, rainfall, wind, and other factors. Climate describes the weather of a place averaged over a period of time, often 30 years."));
        faqs.add(new QuestionAnswer("What is climate change?", "Climate change involves significant changes in average conditions—such as temperature, precipitation, wind patterns, and other aspects of climate—that occur over years, decades, centuries, or longer."));
        faqs.add(new QuestionAnswer("What is the difference between global warming and climate change?", "The terms 'global warming' and 'climate change' are sometimes used interchangeably, but global warming is just one of the ways in which climate is affected by rising concentrations of greenhouse gases."));
        faqs.add(new QuestionAnswer("What is the difference between climate change and climate variability?", "Climate change occurs over a long period of time, typically over decades or longer. Climate variability includes changes that occur within shorter timeframes, such as a month, season, or year."));
        faqs.add(new QuestionAnswer("Is there scientific consensus that people are causing today’s climate change?", "Yes. Climate scientists overwhelmingly agree that people are contributing significantly to today’s climate change, primarily by releasing excess greenhouse gases into the atmosphere from activities such as burning fossil fuels."));
        faqs.add(new QuestionAnswer("What is a temperature anomaly?", "The term temperature anomaly means a departure from a reference value or long-term average. A positive anomaly indicates that the observed temperature was warmer than the reference value, while a negative anomaly indicates that the observed temperature was cooler than the reference value."));
        faqs.add(new QuestionAnswer("What can the mean global temperature anomaly be used for?", "This product is a global-scale climate diagnostic tool and provides a big picture overview of average global temperatures compared to a reference value."));
        faqs.add(new QuestionAnswer("Why use temperature anomalies (departure from average) and not absolute temperature measurements?", "Absolute estimates of global average surface temperature are difficult to compile for several reasons. Some regions have few temperature measurement stations (e.g., the Sahara Desert) and interpolation must be made over large data-sparse regions."));
        faqs.add(new QuestionAnswer("How is the average global temperature anomaly time-series calculated?", "The global time series is produced from the Smith and Reynolds blended land and ocean data set (Smith et al. 2008). This data set consists of monthly average temperature anomalies on a 5° x 5° grid across land and ocean surfaces."));
    }

    public List<QuestionAnswer> getFaqs() {
        return faqs;
    }

    public void addFAQ(String question, String answer) {
        faqs.add(new QuestionAnswer(question, answer));
    }

    public void updateFAQ(int index, String question, String answer) {
        if (index >= 0 && index < faqs.size()) {
            faqs.set(index, new QuestionAnswer(question, answer));
        }
    }

    public void deleteFAQ(int index) {
        if (index >= 0 && index < faqs.size()) {
            faqs.remove(index);
        }
    }

    public QuestionAnswer getFAQ(int index) {
        if (index >= 0 && index < faqs.size()) {
            return faqs.get(index);
        }
        return null;
    }

    public static class QuestionAnswer {
        private String question;
        private String answer;

        public QuestionAnswer(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}

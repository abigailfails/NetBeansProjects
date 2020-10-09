package horoscope.astrology;

import java.time.LocalDate;
import java.time.MonthDay;

public class StarSign {

    private final MonthDay[][] dateBounds = {
        {
            MonthDay.parse("--03-21"),
            MonthDay.parse("--04-20"),
            MonthDay.parse("--05-21"),
            MonthDay.parse("--06-21"),
            MonthDay.parse("--07-23"),
            MonthDay.parse("--08-23"),
            MonthDay.parse("--09-23"),
            MonthDay.parse("--10-23"),
            MonthDay.parse("--11-22"),
            MonthDay.parse("--12-22"),
            MonthDay.parse("--01-20"),
            MonthDay.parse("--02-19"),
        },
        {
            MonthDay.parse("--04-19"),
            MonthDay.parse("--05-20"),
            MonthDay.parse("--06-20"),
            MonthDay.parse("--07-22"),
            MonthDay.parse("--08-22"),
            MonthDay.parse("--09-22"),
            MonthDay.parse("--10-22"),
            MonthDay.parse("--11-21"),
            MonthDay.parse("--12-21"),
            MonthDay.parse("--01-19"),
            MonthDay.parse("--02-18"),
            MonthDay.parse("--03-20"),
        },
    };

    /**
     * Star sign name. Index in the array corresponds to position.
     * */
    private final String[] signNames = {
            "Aries", "Taurus", "Gemini",
            "Cancer", "Leo", "Virgo",
            "libra", "Scorpio", "Sagittarius",
            "Capricorn", "Aquarius", "Pisces"
    };

    private LocalDate birthday;
    private int position; /**Will only ever be 0-11*/

    public StarSign(LocalDate birthday) {
        this.birthday = birthday;
        setPosition();
    }

    private void setPosition() {
        MonthDay birthdayMonth = MonthDay.from(birthday);
        birthdayMonth.adjustInto(birthday);
        for (int i=0; i<12; i++) {
            if(birthdayMonth.isAfter(dateBounds[0][i])&&birthdayMonth.isBefore(dateBounds[1][i])) {
                position = i;
                break;
            }
        }
    }
    
    public String getSignName() {
        return signNames[position];
    }

    public int getSignIndex() {
        return position;
    }

}

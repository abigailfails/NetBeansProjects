package horoscope;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.MonthDay;

public class StarSign {
    private final MonthDay[] lowerBounds = {
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
    };
    private final MonthDay[] upperBounds = {
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
    };
    private final String[] signNames = {
            "aries", "taurus", "gemini",
            "cancer", "leo", "virgo",
            "libra", "scorpio", "sagittarius",
            "capricorn", "aquarius", "pisces"
    };
    private final String[] messages = {
            "Murphy’s Law seems to be the rule of the day. When everything is under control in one area, little things demand attention in another today. Although you might wish differently, the simple fact is impermanence is a featured quality of most human endeavors while perpetual harmony only works out beautifully in dreams. Fortunately, your multitasking skills are up to the task now. Loved ones and workmates suspect that you secretly thrive on the hustle and bustle. It is fun to keep them guessing about whether they are right. Your infectious energy is your weapon of choice.",
            "You may often play the strong and silent type, rarely gushing over your feelings unless it’s warranted. Instead, you bring mature focus to emotions and a responsible brand of purpose to your helpfulness. Your pragmatic approach puts you in the catbird seat when it comes to showing another person that you care today. Drive the carpool, buy the coffee, or field a tough phone call on their behalf. There are countless practical ways to express what is in your heart. Your authenticity speaks volumes when your actions are on point.",
            "Corralling stray thoughts can be a lot like trying to herd cats today. With a special event or deadline looming ever nearer, you sense that the most headway can be made by concentrating on one priority at a time. But maintaining this mental focus is easier said than done when there is so much of interest going on around you. Have patience with your wandering mind and give your thoughts a chance to crystallize on their own volition. Like a feline, inspiration has an uncanny knack for finding its way home.",
            "Intuition enters the picture as the practical voice of reason that plays at the back of your mind. Instinctive responses are cautious today, especially when you are working your way through matters of money, business, or commerce. There are benefits to a slow and steady approach, not the least of which might be less stress or increased prosperity. If you rush or fuss, you risk overlooking an important detail. Thankfully, even a large mountain can be moved one small stone at a time.",
            "You have so many better things to do than jump through hoops just to make someone happy. However, it is only natural to wish to want to please those you admire. But if contortion is required to fit in, it is a huge red flag that the crowd you are trying to join is not the right one for you. You are a strong, proud individual -- your own person through and through. Changing so others will appreciate you is like driving on a tire that has an invisible leak. Sooner or later, it is going to go flat. Your true vibe attracts your genuine tribe.",
            "Your eagle eye works like a charm today. A cornerstone of your originality is your ability to spot the creative possibilities in activities or items that most others see as strictly utilitarian. Don’t be distracted by those who question why or how you could be so intrigued by what they consider mundane. The proof is in the pudding and your results consistently exceed even your own very high standards, especially in areas of health, hygiene, and science. Author Jeffrey Fry wrote, ‘Only those who can see the invisible can do the impossible.’",
            "Step into a leadership role with surety, and you can designate, delegate, and guide with confidence. Whether the job at hand looks to be a thrill a minute or is basically a series of yawns, you realize that accomplishment is about far more than excitement or boredom. Your instinctual understanding of the deeper significance of today’s itinerary throws a lot of responsibility in your direction. Take charge of your own positive attitude and others are inspired to see things your way. Without hard work, nothing grows but weeds.",
            "Take a deep breath and prepare to share whatever crosses your mind. Begin a conversation, make a sales pitch, compose an editorial, or create art. Your thoughts and feelings flow almost as if moving through a funnel today, empowering you to concentrate with laser-like precision. The results might include a surprising realization or two, some profound insights, and a whole lot of emotions you need to get off your chest. Finding the right outlet for all of your intensity is the real trick. Author Pearl Buck wrote, ‘Self-expression must pass into communication for its fulfillment.’",
            "Advance on all fronts, but do so carefully and mindfully today. Hints and clues trace a path forward; simultaneously, signal lights flash to warn you away from pitfalls like excess. Be deliberate about every footfall and you can successfully broaden your range of influence or multiply the scope of realistic options on your menu. You may not be able to snap your fingers and immediately make what you wish for appear. But thankfully, little by little, you can inch closer to it. Progress isn’t measured by a straight line.",
            "You can thrive when in the public eye today. Your social skills are so in the groove that you may sail through any engagement almost exclusively by virtue of your charm alone. If you want to assume a higher profile within a group, club, or organization, the ideal opportunity to state your case could arise. Others are exceptionally receptive to your message now. And, with the gentlest of nudges, many seem ready to offer abundant encouragement and support. Soak up the vitality of a caring community spirit while you can. Paying the kindness forward is an absolute pleasure.",
            "Evolution is a necessary part of growth. You might find it cringeworthy if the sole-stated reason for a person or company favoring one method over another is because of tradition. You can be so progressive in your thinking that it is difficult to muster up much patience for stalwart adherence to the status quo. However, small changes made in delicate increments could be the least disruptive way to proceed when an update is required. A little of this, a little of that, and all of a sudden, innovation is knocking at your door. A perfect mix of the old and the new cultivates a creative environment.",
            "A surprise can really do a number on your preconceptions today. And as unnerving as an unexpected event might be, it’s also a kind of awakening when you are open to learning on the fly. This could be a cosmic reminder that the whole of your everyday routine adds up to more than merely the sum of its various parts. Not every experience fits conveniently into a neat compartment and if it did, boredom would quickly descend. Thankfully, you can be in the present without struggling to define it. Poet Omar Khayyam said, ‘Be happy for this moment. This moment is your life.’"
    };
    private LocalDate birthday;
    private int position; /**Should be 0-11*/

    public StarSign (LocalDate birthday) {
        this.birthday = birthday;
        setPosition();
    }

    private void setPosition() {
        MonthDay birthdayMonth = MonthDay.from(birthday);
        birthdayMonth.adjustInto(birthday);
        for (int i=0; i<12; i++) {
            if(birthdayMonth.isAfter(lowerBounds[i])&&birthdayMonth.isBefore(upperBounds[i])) {
                position = i;
                break;
            }
        }
    }
    
    public String getSign() {
        return signNames[position];
    }

    public String getMessage() {
        return messages[position];
    }

}

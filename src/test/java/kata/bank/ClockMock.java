package kata.bank;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClockMock {

    static final LocalDateTime DEFAULT_TIME = LocalDateTime.parse("2021-12-22T18:00:00");

    static Clock givenTimeIs(LocalDateTime time) {
        Clock clock = mock(Clock.class);

        when(clock.getTime()).thenReturn(time);

        return clock;
    }

    static Clock withDefaultTime() {
        return givenTimeIs(DEFAULT_TIME);
    }
}

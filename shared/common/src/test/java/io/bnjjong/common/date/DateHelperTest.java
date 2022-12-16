package io.bnjjong.common.date;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * create on 2022/12/16. create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jongsang Han(henry)
 * @version 1.0
 * @see
 * @since 1.0
 */
class DateHelperTest {

  @Test
  void Given_Date_When_ConvertToLocalDateTimeViaInstant_Then_LocalDateTime() {
    // given
    Date date = new Date();
    // when
    LocalDateTime localDateTime = DateHelper.convertToLocalDateTimeViaInstant(date);
    // then
    assertEquals(
        localDateTime
        , date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
    );
  }

  @Test
  void Given_Date_When_ConvertToLocalDateViaInstant_Then_LocalDate() {
    // given
    Date date = new Date();
    // when
    LocalDate localDate = DateHelper.convertToLocalDateViaInstant(date);
    // then
    assertEquals(
        localDate
        , date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
    );
  }

  @Test
  void Given_LocalDate_When_GetYyyymmdd_Then_StringFormatDate() {
    // given
    LocalDate localDate = LocalDate.now();
    // when
    String yyyymmdd = DateHelper.getYyyymmdd(localDate);
    // then
    assertEquals(yyyymmdd, localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
  }
}
package io.bnjjong.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
public class DateHelper {
  private static final SimpleDateFormat formatYyyyMmDdHyphen = new SimpleDateFormat("yyyy-MM-dd");

  private DateHelper() {
  }

  /**
   *
   * <p> Convert Date to LocalDateTIme. </p>
   *
   * @param dateToConvert {@code Date} object to want to convert to {@code LocalDateTime} type.
   * @return converted {@code LocalDateTime} object.
   */
  public static LocalDateTime convertToLocalDateTimeViaInstant(final Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
  }

  /**
   * <p> Convert Date to LocalDate. </p>
   *
   * @param dateToConvert {@code Date} object to want to convert to {@code LocalDateTime} type.
   * @return converted {@code LocalDate} object.
   */
  public static LocalDate convertToLocalDateViaInstant(final Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();
  }

  /**
   * <pre>
   *   Return pattern of string date like {@code yyyyMMdd} for inputted date.
   *   ex)
   *   String today = DateHelper.getYyyymmdd(LocalDate.now());
   * </pre>
   *
   * @param date Input date for convert to {@code String} of yyyyMMdd.
   * @return return {@code String} type of yyyyMMdd.
   */
  public static String getYyyymmdd(final LocalDate date) {
    return date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
  }

  /**
   *
   * @param yyyymmddHyphen date with hyphen. ex) 2022-01-30
   * @return LocalDateTime
   * @throws ParseException
   * @since 1.1.0
   */
  public static LocalDateTime convertLocalDateTimeByYyyymmddHyphen(final String yyyymmddHyphen)
      throws ParseException {
    Date date = formatYyyyMmDdHyphen.parse(yyyymmddHyphen);
    return DateHelper.convertToLocalDateTimeViaInstant(date);
  }
}

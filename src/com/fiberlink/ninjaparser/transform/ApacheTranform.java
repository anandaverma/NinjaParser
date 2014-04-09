package com.fiberlink.ninjaparser.transform;

import java.util.regex.*;

import com.fiberlink.ninjaparser.util.ApacheCombinedLogFormat;

/**
 * Common fields for Apache Log demo.
 */
interface LogExample {
  /** The number of fields that must be found. */
  public static final int NUM_FIELDS = 10;

}
/**
 * Parse an Apache log file with Regular Expressions
 */
public class ApacheTranform implements LogExample, Transform {

  public ApacheCombinedLogFormat apacheCombinedLogParser (String logEntryLine) {
	ApacheCombinedLogFormat aclf = new ApacheCombinedLogFormat();
    String logEntryPattern = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \\\"(\\S+) \\/+(.+)\\\" (\\d{3}) (.+) \\\"([^\\\"]+)\\\" \\\"([^\\\"]+)\\\"";

    Pattern p = Pattern.compile(logEntryPattern);
    Matcher matcher = p.matcher(logEntryLine);
    if (!matcher.matches() || 
      NUM_FIELDS != matcher.groupCount()) {
    }
    else {
    
    aclf.setIpaddrr(matcher.group(1));
    aclf.setRemotelogname(matcher.group(2));
    aclf.setRemoteuser(matcher.group(3));
    aclf.setTime(matcher.group(4));
    aclf.setMethod(matcher.group(5));
    aclf.setRequest(matcher.group(6));
    aclf.setResponse(matcher.group(7));
    aclf.setBytessent(matcher.group(8));
    aclf.setReferer(matcher.group(9));
    aclf.setBrowser(matcher.group(10));
    }
    return aclf;
  }
}


package Practice.java.chap01;

import org.apache.commons.lang3.StringUtils;

public class PracticeTrim {

public int PrTrimExe(String text) {

	int textnum = StringUtils.deleteWhitespace(text).length();
	return textnum;
}
}


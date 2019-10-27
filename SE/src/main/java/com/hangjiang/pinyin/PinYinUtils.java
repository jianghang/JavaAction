package com.hangjiang.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtils {

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

        String str = "你E好行tefadfasd";
        char[] srcChar = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : srcChar) {
            builder.append(getHeadByChar(c, true));
        }
        System.out.println(builder.toString());

        String pinyinStr = PinyinHelper.toHanYuPinyinString(str, outputFormat, "", true);
        System.out.println(pinyinStr);
    }

    public static char getHeadByChar(char src, boolean isCapital) {
        if (src <= 128) {
            return src;
        }
        String[] pinyinStrArray = PinyinHelper.toHanyuPinyinStringArray(src);
        if (pinyinStrArray.length > 0) {
            String temp = pinyinStrArray[0];
            char headChar = temp.toCharArray()[0];
            if (isCapital) {
                return Character.toUpperCase(headChar);
            } else {
                return headChar;
            }
        }
        return src;
    }
}

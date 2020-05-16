package com.thintime.bigdataui.fragment;

/**
 * @author Thintime
 * @create 2020/4/30
 * @desc todo 碎片化知识4：原码
 */
public class TrueForm {
    /*原码：二进制左边+最高位符号位(0+，1-),故理论范围是[-127, 127]
    原码不适用正负数相加，故出现了反码：正数的反码=原码，负数的反码保留符号位而其他位取反
            (+1)+(-1)=00000001+11111110=11111111(0的反码)
    反码会出现+0和-0，故出现补码：正数的补码=原码，负数的补码=反码+1
    补码可能会出现最高位丢失：11111111(-0)进一位=100000000->00000000
    故-0不存在，省下的10000000就用来表示-128(没有对应的原码、反码)->实际范围为[-128, 127]*/
}

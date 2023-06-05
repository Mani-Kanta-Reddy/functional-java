package com.neon.functionalinterface;

import java.util.function.Predicate;

public class _Predicate
{
    public static void main(String[] args)
    {
        String phone1 = "9198797632";
        String phone2 = "8799799";
        String phone3 = "91349374";
        System.out.println(isPhoneValid(phone1));
        System.out.println(isPhoneValid(phone2));

        //Predicate
        System.out.println(isPhoneValid.test(phone1));
        System.out.println(isPhoneValid.test(phone2));
        System.out.println(isPhoneValid.and(contains3).test(phone1));
        System.out.println(isPhoneValid.or(contains3).test(phone3));

        //We also have BiPredicate
    }

    static Predicate<String> isPhoneValid = (mobile) -> mobile.startsWith("91") && mobile.length() == 10;

    static Predicate<String> contains3 = mobile -> mobile.contains("3");

    static boolean isPhoneValid(String phone) {
        return phone.startsWith("91") && phone.length() == 10;
    }
}

package main.java.Impl.leetcode.year2019;

import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {

    /*
    42. Trapping Rain Water

    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

    Example:

    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                water += (leftMax-height[left]);
                left++;
            } else {
                water += (rightMax-height[right]);
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        String[] arr_eaa = {"eap","ea play","eaplay","ea pl","ea p","eax","access","eaa","ea access","play first trial","pft","vault","electronic arts"};

        String[] arr_psplus_siea = {"plus","ps plus","ps pl","plus 14","ps p","playstation plus","ps plu","ps plus 14","psp","psplus","ps plus games","plus 1","ps plus 1","playstation plus 14","ps plus: 14","ps plus free","free ps plus","ps plus:14","plus14","fortnite plus","eso plus","playstation plus games","ps+"};
        String[] arr_psnow_siea = {"ps n","ps now","now","psn","psnow","playstation n","playstation no","ps now free","playstation now free","ps now 7","playstation now 7","stream","streaming","cloud","ps3","ps2"};
        String[] arr_eaa_siea = {"eaa","ea acccess","eaaccess","ea ac","ea a","eax","access","play first trial","pft","vault","electronic arts"};


        String[] arr_psplus_siee = {"plus","ps plus","playstation plus","ps pl","ps plu","ps p","plus 14","psplus","playstation plu","ps plus 14","plus14","ps plus 12","playstation plus 1","plus 1","plus 3","psn","playstationplus","pspl","ps plus games","fortnite ps plus","psplu","plus 12","playstation plus 14","ps plus 1 mo","playstation pl","play station plus","ps+","ps plus fortnite","ps plus spiele","eso plus","fortnite plus"};
        String[] arr_psnow_siee = {"ps now","ps","ps n","now","playstation now","ps no","playstation n","playstation no","ps plus 12","psnow","psn","stream","streaming","cloud","ps3","ps2"};
        String[] arr_eaa_siee = {"eaa","ea acccess","eaaccess","ea ac","ea a","eax","access","play first trial","pft","vault","electronic arts"};

        String[] arr_psplus_siej = {"plus","ps plus","playstation plus","プレイステーションプラス","ps p","plus 14","プレステーションプラス","psp　体験版","play station plus","ps plus 14","ps pl","PSP無料","プラス","ps+"};
        String[] arr_psnow_siej = {"ps now","now","playstation hits","playstation now","playstationhits","ps n","playstation n","ナウ","stream","streaming","cloud","ps3","ps2"};
        String[] arr_eaa_siej = {"eaa","ea acccess","eaaccess","ea ac","ea a","eax","access","play first trial","pft","vault","electronic arts"};

        String[] arr_psplus_asia = {"plus","ps plus","playstation plus","playstation pl","playstation plu","psn plus","psplus","ps pl","ps+"};
        String[] arr_psnow_asia = {"playstation hits","psn","playstation now","playstationhits","ps now","playstation hit","stream","streaming","cloud","ps3","ps2"};
        String[] arr_eaa_asia = {"eaa","ea acccess","eaaccess","ea ac","ea a","eax","access","play first trial","pft","vault","electronic arts"};

        String[] siea_locale_arr = {"en_US","fr_CA","en_CA","es_AR","en_AR","pt_BR","en_BR","es_CL","en_CL","es_CO","en_CO","es_MX","en_MX","en_PE","es_PE"};
        String[] siee_locale_arr = {"en_GB","de_AT","fr_BE","nl_BE","en_BG","en_HR","cs_CZ","en_CZ","da_DK","en_DK","en_FI","fi_FI","fr_FR","de_DE","en_GB","el_GR","en_HU","hu_HU","en_IE","it_IT","de_LU","fr_LU","nl_NL","en_NO","no_NO","pl_PL","en_PL","pt_PT","ro_RO","ru_RU","en_SI","es_ES","en_SE","sv_SE","de_CH","fr_CH","it_CH","ru_UA","ar_SA","ar_AE","en_AE","en_GR","en_IL","en_KW","en_QA","en_SA","tr_TR","en_AU","en_IN","en_NZ","en_TR","en_ZA"};
        String[] siej_locale_arr = {"ja_JP"};
        String[] asia_locale_arr = {"zh_CN","zh_HK","ch_HK","en_HK","id_ID","en_ID","ja_JP","ko_KR","en_MY","en_SG","zh_TW","ch_TW","en_TW","en_TH","th_TH","vi_VN"};
        String synonym_name = "EA Play";
        for (String locale : siea_locale_arr) {
//            System.out.println("");
//            String psplus_synonym = "PS Plus";
//            System.out.println(String.format("/* %s - %s */", locale, psplus_synonym));
//            for (String term : arr_psplus_siea) {
//                String resultStr_psplus = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psplus_synonym);
//                System.out.println(resultStr_psplus);
//            }
//            System.out.println("");
//
//            String psnow_synonym = "PS Now";
//            System.out.println(String.format("/* %s - %s */", locale, psnow_synonym));
//            for (String term : arr_psnow_siea) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psnow_synonym);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_siea) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, eaa_synonym);
//                System.out.println(resultStr);
//            }
//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* Delete %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_siea) {
//                String resultStr = String.format("delete from search_synonym_mapping where locale='%s' and term='%s';", locale, term);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String new_eaa_synonym = "EA Play";
//            System.out.println(String.format("/* Insert %s - %s */", locale, new_eaa_synonym));
//            for (String term : arr_eaa) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, new_eaa_synonym);
//                System.out.println(resultStr);
//            }
            System.out.println(String.format("select count(*) from search_synonym_mapping where locale='%s' and synonym='%s' ALLOW FILTERING;", locale, synonym_name));
        }

        for (String locale : siee_locale_arr) {
//            System.out.println("");
//            String psplus_synonym = "PS Plus";
//            System.out.println(String.format("/* %s - %s */", locale, psplus_synonym));
//            for (String term : arr_psplus_siee) {
//                String resultStr_psplus = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psplus_synonym);
//                System.out.println(resultStr_psplus);
//            }
//            System.out.println("");
//
//            String psnow_synonym = "PS Now";
//            System.out.println(String.format("/* %s - %s */", locale, psnow_synonym));
//            for (String term : arr_psnow_siee) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psnow_synonym);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_siee) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, eaa_synonym);
//                System.out.println(resultStr);
//            }

//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* Delete %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_siee) {
//                String resultStr = String.format("delete from search_synonym_mapping where locale='%s' and term='%s';", locale, term);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String new_eaa_synonym = "EA Play";
//            System.out.println(String.format("/* Insert %s - %s */", locale, new_eaa_synonym));
//            for (String term : arr_eaa) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, new_eaa_synonym);
//                System.out.println(resultStr);
//            }
            System.out.println(String.format("select count(*) from search_synonym_mapping where locale='%s' and synonym='%s' ALLOW FILTERING;", locale, synonym_name));
        }


        for (String locale : siej_locale_arr) {
//            System.out.println("");
//            String psplus_synonym = "PS Plus";
//            System.out.println(String.format("/* %s - %s */", locale, psplus_synonym));
//            for (String term : arr_psplus_siej) {
//                String resultStr_psplus = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psplus_synonym);
//                System.out.println(resultStr_psplus);
//            }
//            System.out.println("");
//
//            String psnow_synonym = "PS Now";
//            System.out.println(String.format("/* %s - %s */", locale, psnow_synonym));
//            for (String term : arr_psnow_siej) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psnow_synonym);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_siej) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, eaa_synonym);
//                System.out.println(resultStr);
//            }

//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* Delete %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_siej) {
//                String resultStr = String.format("delete from search_synonym_mapping where locale='%s' and term='%s';", locale, term);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String new_eaa_synonym = "EA Play";
//            System.out.println(String.format("/* Insert %s - %s */", locale, new_eaa_synonym));
//            for (String term : arr_eaa) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, new_eaa_synonym);
//                System.out.println(resultStr);
//            }
            System.out.println(String.format("select count(*) from search_synonym_mapping where locale='%s' and synonym='%s' ALLOW FILTERING;", locale, synonym_name));
        }


        for (String locale : asia_locale_arr) {
//            System.out.println("");
//            String psplus_synonym = "PS Plus";
//            System.out.println(String.format("/* %s - %s */", locale, psplus_synonym));
//            for (String term : arr_psplus_asia) {
//                String resultStr_psplus = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psplus_synonym);
//                System.out.println(resultStr_psplus);
//            }
//            System.out.println("");
//
//            String psnow_synonym = "PS Now";
//            System.out.println(String.format("/* %s - %s */", locale, psnow_synonym));
//            for (String term : arr_psnow_asia) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, psnow_synonym);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_asia) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, eaa_synonym);
//                System.out.println(resultStr);
//            }

//            System.out.println("");
//            String eaa_synonym = "EA Access";
//            System.out.println(String.format("/* Delete %s - %s */", locale, eaa_synonym));
//            for (String term : arr_eaa_asia) {
//                String resultStr = String.format("delete from search_synonym_mapping where locale='%s' and term='%s';", locale, term);
//                System.out.println(resultStr);
//            }
//
//            System.out.println("");
//            String new_eaa_synonym = "EA Play";
//            System.out.println(String.format("/* Insert %s - %s */", locale, new_eaa_synonym));
//            for (String term : arr_eaa) {
//                String resultStr = String.format("insert into search_synonym_mapping (locale, term, synonym) values ('%s','%s','%s');", locale, term, new_eaa_synonym);
//                System.out.println(resultStr);
//            }
            System.out.println(String.format("select count(*) from search_synonym_mapping where locale='%s' and synonym='%s' ALLOW FILTERING;", locale, synonym_name));
        }

    }

}

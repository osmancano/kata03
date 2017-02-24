package com.ironyard.data;

import java.util.*;

/**
 * Created by osmanidris on 2/24/17.
 */
public class Kata {
    public static boolean firstLast6(List<String> arrayList){
        boolean flag = false;
        if(arrayList.indexOf("6")==0 || arrayList.lastIndexOf("6")==arrayList.size()-1) {
            flag = true;
        }
        return flag;
    }
    public static boolean sameFirstLast(List<String> arrayList){
        boolean flag = false;
        if(arrayList.get(0) == arrayList.get(arrayList.size()-1)) {
            flag = true;
        }
        return flag;
    }
    public static ArrayList rotateLeft3(List<String> arrayList){
        ArrayList<String> tempList = new ArrayList<>(arrayList);
        String temElement = tempList.get(0);
        tempList.remove(0);
        tempList.add(temElement);
        return tempList;
    }
    public static ArrayList reverse3(List<String> arrayList){
        ArrayList<String> tempList = new ArrayList<>(arrayList);
        Collections.reverse(tempList);
        return tempList;
    }

    public static Integer sumFirstPenultimate(List<String> arrayList){
        Integer sum = 0;
        if(arrayList.size()==1){
            sum = Integer.parseInt(arrayList.get(0));
        }else if(arrayList.size()==2){
            sum = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(arrayList.size()-1));
        }else{
            sum = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(arrayList.size()-2));
        }
        return sum;
    }

    public static HashMap<String,String> mapBully(HashMap<String,String> hashMap){
        HashMap<String,String> tempHashMap = new HashMap<String,String>(hashMap);
        String aValue = tempHashMap.get("a");
        if (aValue != null && aValue != "")
        {
            tempHashMap.put("b", aValue);
            tempHashMap.put("a", "");
        }
        return tempHashMap;
    }

    public static HashMap<String, String> mapShare(HashMap<String, String> hashMap)
    {
        HashMap<String, String> tempHashMap = new HashMap<>(hashMap);

        String aValue = tempHashMap.get("a");
        if (aValue != null && aValue != "")
        {
            tempHashMap.put("b", aValue);
            tempHashMap.remove("c");
        }
        return tempHashMap;
    }

    public static HashMap<String, String> mapAB(HashMap<String, String> hashMap)
    {
        HashMap<String, String> tempHashMap = new HashMap<>(hashMap);

        String aValue = tempHashMap.get("a");
        String bValue = tempHashMap.get("b");
        if (aValue != null && bValue != null)
        {
            tempHashMap.put("ab", aValue + bValue);
        }
        return tempHashMap;
    }

    public static HashMap<String, Integer> wordLength(List<String> arrayList)
    {
        HashMap<String, Integer> tempHashMap = new HashMap<>();

        for (String item: arrayList)
        {
            if (tempHashMap.get(item) == null)
            {
                tempHashMap.put(item, item.length());
            }
        }

        return tempHashMap;
    }

    public static HashMap<String, ArrayList<String>> indexWords(List<String> arrayList)
    {
        HashMap<String, ArrayList<String>> tempHashMap = new HashMap<>();

        for (String iItem: arrayList)
        {
            if (iItem.length() == 0)
                continue;

            String fl = iItem.substring(0, 1);
            if (tempHashMap.get(fl) == null)
            {
                ArrayList<String> tempArrayList = new ArrayList<>();

                for (String jItem: arrayList)
                {
                    if (jItem.length() == 0)
                        continue;

                    String jFirstLetter = jItem.substring(0, 1);
                    if (jFirstLetter.equals(fl))
                    {
                        tempArrayList.add(jItem);
                    }
                }

                tempHashMap.put(fl, tempArrayList);
            }
        }

        return tempHashMap;
    }

}

package com.bhavadeep.letterlookbackjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterLookback {
    public static void main(String[] args) {
    	
        int lookBack = 0;
        FileParser fileParser = null;
        if (args.length == 2) {
            printArguments(args);
         // Read the file and parse it
            fileParser = new FileParser(args[0]);
            try {
            	// Read the lookback value from the argument
                lookBack  = Integer.parseInt(args[1]);
            }catch (NumberFormatException ne){
                System.err.println("Lookback value not valid");
            }
        } else {
            System.out.println("Incorrect arguments");
            System.exit(1);
        }
        List<Character> mainInputCharList = fileParser.getCharacterList();

        //HashMap creation to avoid/count duplicated
        Map<Character, Content> hashMap = new HashMap<>();

        //Populating the hashmap with characters from the input list
        populateHashMap(mainInputCharList, hashMap, lookBack);

        //Print the result
        if(hashMap.isEmpty()){
            System.out.println("No such characters found with the given lookback");
        }
        else {
            printResult(hashMap);
        }
    }

    /**
     *
     * @param mainInputCharList - List of characters retrieved from the input file
     * @param hashMap - Hashmap to be populated
     * @param lookBack - Lookback argument from user input
     */
    private static void populateHashMap(List<Character> mainInputCharList, Map<Character, Content> hashMap, int lookBack) {
        if(!mainInputCharList.isEmpty()){
            int count;
            int index = 0;
            int listIndex = 0;

            Content content;
            for(char ch: mainInputCharList){
                if(Character.isAlphabetic(ch)){
                    ch = Character.toLowerCase(ch); // Case-insensitive
                }
                if(hashMap.containsKey(ch)){ // Repeated characters
                    content = hashMap.get(ch);
                    count = content.getCount();
                    if(Math.abs(content.getIndex()-listIndex)<=lookBack){ // Repeated before lookback
                        count++;
                        content.setCount(count);
                    }
                    content.setIndex(index);
                    index++;
                }
                else{
                    content = new Content(index);
                    index++;
                }
                listIndex++;
                hashMap.put(ch, content);
            }
        }

    }

    /**
     * Print the Output
     * @param hashMap - Fully populated HashMap
     */
    private static void printResult(Map<Character, Content> hashMap) {
        System.out.println("========Output========");
        for(HashMap.Entry<Character, Content> result: hashMap.entrySet()){
            if(result.getValue().getCount()>0){ //Only at least once repeated within lookback values
                System.out.println(result.getKey() + "-" + result.getValue().getCount());
            }
        }
        System.out.println("=========================");
    }

    /**
     * Print the Input
     * @param args User input arguments
     */
    private static void printArguments(String[] args) {
        System.out.println("========Arguments========");
        System.out.println("Input file     : " + args[0]);
        System.out.println("Lookback Number: " + args[1]);
        System.out.println("=========================");
    }



}

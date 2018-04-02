//
//@RequestMapping(value="/countshu", method = RequestMethod.POST)
//    public BaseResponse countshu (@RequestParam("longnumber")String longnumber) throws Exception {
//        String[] numbers = longnumber.split(";");
//        int[][] numberArray = new int[numbers.length][numbers.length];
//        String oneNumber = "0";
//        int oneNumberInteger = 0;
//        for (int i = 0 ; i < numbers.length ; i++) {
//            String oneNunbers = numbers[i];
//            String[] oneNumbersArray = oneNunbers.split(",");
//            for (int j = 0 ; j < oneNumbersArray.length ; j++) {
//                oneNumber = oneNumbersArray[j];
//                oneNumberInteger = Integer.parseInt(oneNumber);
//                numberArray[i][j] = oneNumberInteger;
//            }
//        }
//        //multi check
//        boolean nultiCheck = shuChuLiService.getRightShu(numberArray);
//        if (!nultiCheck) {
//            return toSuccess("update_successful" , false);
//        }
//        // sum check
//        boolean perfectCheck = shuChuLiService.getPerfectShu(numberArray);
//        if (perfectCheck) {
//            System.out.println("success");
//        }
//        shuChuLiService.writeToTxt(numberArray , "");
//        return toSuccess("update_successful" , "fail");
//    }

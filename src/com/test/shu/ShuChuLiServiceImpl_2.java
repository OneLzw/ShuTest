//package com.tracenet.service.impl;
//
//import com.tracenet.entities.AccountActivity;
//import com.tracenet.service.IShuChuLiService;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ShuChuLiServiceImpl implements IShuChuLiService {
//
//    @Override
//    public boolean getRightShu(int[][] numberArray) {
//        // 9 multi
//        boolean right = true;
//        List<Integer> numberList = new ArrayList<>();
//        for (int i = 0 ; i < numberArray.length ; i++) {
//            for (int j = 0 ; j <numberArray[i].length ; j++ ) {
//                int oneNumber = numberArray[i][j];
//                if (oneNumber == 0) {
//                    continue;
//                }
//                boolean contain = numberList.contains(oneNumber);
//                if (contain) {
//                    right = false;
//                    break;
//                } else {
//                    numberList.add(oneNumber);
//                }
//            }
//        }
//        return right;
//    }
//
//    /**
//     * 15
//     * @param data
//     * @return
//     */
//    @Override
//    public boolean getPerfectShu(int[][] data) {
//        int sum = 0;
//        boolean result = false;
//        for (int i = 0 ; i < data.length ; i++) {
//            sum = 0;
//            int [] curRow = data[i];
//            for (int j = 0 ; j < curRow.length ; j++) {
//                sum += curRow[j];
//            }
//            if (sum != 15) {
//                break;
//            }
//            sum = 0;
//            for (int k = 0 ; k < data.length ; k++) {
//                sum += data[k][i];
//            }
//            if (sum != 15) {
//                break;
//            }
//        }
//        if (sum == 15) {
//            result = true;
//        }
//        return result;
//    }
//
//
//    @Override
//    public void writeToTxt(int[][] numberArray , String nameIndex) throws  Exception {
//        File file = new File("C:\\Users\\Administrator\\Desktop\\txt\\data" + nameIndex + ".txt");
//        if (file.exists()) {
//            int namei = StringUtils.isEmpty(nameIndex) ? 0 : Integer.parseInt(nameIndex) + 1;
//            writeToTxt(numberArray , namei + "");
//            return;
//        }
//        String numberString = getString(numberArray);
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.write(numberString.getBytes());
//        fos.close();
//
//    }
//
//    @Override
//    public List<List<Integer>> getFinishShu(int[][] data) {
//        List<List<Integer>> finishShu = new ArrayList<>();
//        if (data[1][1] != 5) {
//            return null;
//        }
//        Map<String , List<Integer>> emptyMap = getEmpty(data);
//        return finishShu;
//    }
//
//    public  Map<String , List<Integer>> getEmpty(int[][] data){
//        Map<String , List<Integer>> emptyMap = new HashMap<>();
//        List<Integer> emptyList = null;
//        for (int i = 0 ; i < data.length ; i++) {
//            int [] curRow = data[i];
//            for (int j = 0 ; j < curRow.length ; j++) {
//                emptyList = new ArrayList<>();
//                if (curRow[j] != 0) {
//                    continue;
//                }
//                emptyList = getEmptyList(data , i , j);
//                emptyMap.put(i + "," + j , emptyList);
//            }
//        }
//        return emptyMap;
//    }
//
//    public List<Integer> getEmptyList(int[][] data , int m , int n){
//        List<Integer> list = getList();
//        int[] row = data[m];
//        for (int i = 0 ; i < row.length ; i++ ) {
//            int curNumber = row[i];
//            if (!list.contains(curNumber)) {
//                continue;
//            }
//            list.remove(list.indexOf(curNumber));
//        }
//
//        for (int i = 0 ; i < data.length ; i++) {
//            int curNumber = data[i][n];
//            if (!list.contains(curNumber)) {
//                continue;
//            }
//            list.remove(list.indexOf(curNumber));
//        }
//        return list;
//    }
//
//    public String getString(int[][] numberArray){
//        StringBuilder sbu = new StringBuilder();
//        for (int i = 0 ; i < numberArray.length ; i++) {
//            for (int j = 0 ; j < numberArray[i].length ; j++) {
//                int curNumber = numberArray[i][j];
//                if (j == numberArray[i].length - 1) {
//                    sbu.append(curNumber);
//                } else {
//                    sbu.append(curNumber + ",");
//                }
//            }
//            if (i != numberArray.length - 1) {
//                sbu.append("\n");
//            }
//        }
//        return sbu.toString();
//    }
//
//    @Override
//    public AccountActivity getById(Object id) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<AccountActivity> getAll() throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<AccountActivity> getByExample(Example example) throws Exception {
//        return null;
//    }
//
//    @Override
//    public AccountActivity getUniqueByExample(Example example) throws Exception {
//        return null;
//    }
//
//    @Override
//    public int deleteById(Object id) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int delByIds(String ids) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int deleteByExample(Example example) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int updateById(AccountActivity obj) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public int save(AccountActivity obj) throws Exception {
//        return 0;
//    }
//
//    @Override
//    public void savAll(List<AccountActivity> list) throws Exception {
//
//    }
//
//    public List<Integer> getList(){
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1 ; i < 10 ; i++) {
//            list.add(i);
//        }
//        return list;
//    }
//}

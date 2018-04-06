package com.tracenet.service;

import com.tracenet.entities.AccountActivity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface IShuChuLiService extends IBaseService<AccountActivity>{

    public boolean getRightShu (int[][] shu);

    public boolean getPerfectShu(int[][] shu);

    public void writeToTxt (int[][] data , String nameIndex , boolean perfect) throws Exception;

    public List<List<Integer>> getFinishShu(int[][] data);

    public Map<String , List<int[][]>> getHistory();
}

package com.webexam.common.cache;

import com.webexam.common.entity.Problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ProblemCache
 *
 * @author: zhangteng
 * @time: 14-2-11 下午9:59
 */
public final class ProblemCache {

    private static Map<String, Object> cacheMap = new HashMap<String, Object>();

    /**
     * 根据专业和科目从缓存中获取题目
     *
     * @param majorCode
     * @param subCode
     * @return
     */
    public static List<Problem> getProblemsByMajorAndSub(String majorCode, String subCode) {
        Object obj = cacheMap.get(majorCode + "-" + subCode);
        if(obj != null) {
            return (List) obj;
        } else {
            return null;
        }
    }

    /**
     * 向缓存中添加题目
     *
     * @param problemList
     */
    public static void putProblems(List<Problem> problemList) {
        String majorCode = problemList.get(0).getMajorCode(),
               subCode = problemList.get(0).getSubjectCode();
        cacheMap.put(majorCode + "-" + subCode, problemList);
    }

    /**
     * 向缓存中添加题目
     *
     * @param problem
     */
    public static void putProblem(Problem problem) {
        List<Problem> problemList = getProblemsByMajorAndSub(problem.getMajorCode(), problem.getSubjectCode());
        boolean existed = false;
        if(problemList != null) {
	        for(Problem problem1 : problemList) {
	            if(problem1.getId() == problem.getId()) {
	                problem1 = problem;
	                existed = true;
	                break;
	            }
	        }
	        if(existed == false) {
	            problemList.add(problem);
	        }
	    }
    }

    /**
     * 从缓存中删除题目
     *
     * @param problem
     */
    public static void removeProblem(Problem problem) {
        List<Problem> problemList = getProblemsByMajorAndSub(problem.getMajorCode(), problem.getSubjectCode());
        if(problemList != null) {
            for(Iterator it = problemList.iterator(); it.hasNext(); ) {
                Problem p = (Problem) it.next();
                if(p.getId() == problem.getId()) {
                    it.remove();
                    break;
                }
            }
        }
    }
}

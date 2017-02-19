package com.deep.two.dao.util;

import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import com.deep.two.util.StringUtil;
import com.deep.two.util.ViewException;

public final class CriterionUtil {
    
    private CriterionUtil() {
        
    }

    /**
     * 
     * createCriterion:把list(CriteriaUnit)转成Criterion <br/>
     * @exception 
     * @param createCriterionList CriterionUnit对象的list结构
     * @return Criterion 返回Criterion(里面封装有查询条件)
     * @throws ViewException 会有"oprator不符合规则 不是 in like = >之类的查询标识符"异常
     *            调取createCriterion方法会有异常 <br/> 
     */
    public static Criterion createCriterion(List<CriterionUnit> createCriterionList) throws ViewException {

        Criterion lastCriterion = null;
        Criterion firstCriterion = null;
        if (createCriterionList == null || createCriterionList.isEmpty()) {
            return lastCriterion;
        } else {
            for (int i = 0; i < createCriterionList.size(); i++) {
                CriterionUnit cr = (CriterionUnit) createCriterionList.get(i);
                Criterion createCriterion = createCriterion(cr);
                if (i == 0) {
                    firstCriterion = createCriterion;
                    lastCriterion = createCriterion;
                } else {
                    lastCriterion = Restrictions.and(firstCriterion, createCriterion);
                    firstCriterion = lastCriterion;
                }
            }
            return lastCriterion;
        }
    }

    /**
     * 
     * createCriterion:根据CriteriaUnit对象返回Criterion <br/>
     * @exception
     * @param unit CriterionUnit对象 里面封装查询条件key value 查询符号
     * @return Criterion (里面封装查询条件)
     * @throws ViewException 会有"oprator不符合规则 不是 in like = >之类的查询标识符"异常
     *            调取createCriterion方法会有异常 <br/> 
     */
    public static Criterion createCriterion(CriterionUnit unit) throws ViewException {

        Criterion criterion = null;
        if (unit != null) {
            String fieldName = unit.getKey();
            Object value = unit.getValue();
            String oprator = unit.getOperator();
            if (oprator.equals(Operator.GT)) {
                // 大于
                criterion = Restrictions.gt(fieldName, value);
            } else if (oprator.equals(Operator.LT)) {
                // 小于
                criterion = Restrictions.lt(fieldName, value);
            } else if (oprator.equals(Operator.EQ)) {
                // 等于
                criterion = Restrictions.eq(fieldName, value);
            } else if (oprator.equals(Operator.NE)) {
                // 不等于
                criterion = Restrictions.ne(fieldName, value);
            } else if (oprator.equals(Operator.GE)) {
                // >=
                criterion = Restrictions.ge(fieldName, value);
            } else if (oprator.equals(Operator.LE)) {
                // <=
                criterion = Restrictions.le(fieldName, value);
            } else if (oprator.equals(Operator.LK)) {
                criterion = Restrictions.like(fieldName, "%"+value+"%");
            }  else if (oprator.equals(Operator.MULTILK)) {
                criterion = getMultiLike(fieldName, value);
            } else if (oprator.equals(Operator.IN)) {
                String str = (String) value;
                String [] values = str.split(",");
                criterion = Restrictions.in(fieldName, values);
            }else if(oprator.equals(Operator.ISNULL)){
                // isNull
                if(value==null || value.equals("")){
                    criterion = Restrictions.isNull(fieldName);
                }else{
                    criterion = Restrictions.eq(fieldName, value);
                }
                
            }else if(oprator.equals(Operator.ISNOTNULL)){
                // isNotNull
                if(value==null || value.equals("")){
                    criterion = Restrictions.isNotNull(fieldName);
                }else{
                    criterion = Restrictions.eq(fieldName, value);
                }
            } 
            else if (oprator.equals(Operator.GT_PROPERTY)) {
                // 大于PROPERTY
                criterion = Restrictions.gtProperty(fieldName, value.toString());
            } else if (oprator.equals(Operator.LT_PROPERTY)) {
                // 小于PROPERTY
                criterion = Restrictions.ltProperty(fieldName, value.toString());
            } else if (oprator.equals(Operator.EQ_PROPERTY)) {
                // 等于PROPERTY
                criterion = Restrictions.eqProperty(fieldName, value.toString());
            } else if (oprator.equals(Operator.NE_PROPERTY)) {
                // 不等于PROPERTY
                criterion = Restrictions.neProperty(fieldName, value.toString());
            } else if (oprator.equals(Operator.GE_PROPERTY)) {
                // >=PROPERTY
                criterion = Restrictions.geProperty(fieldName, value.toString());
            } else if (oprator.equals(Operator.LE_PROPERTY)) {
                // <=PROPERTY
                criterion = Restrictions.leProperty(fieldName, value.toString());
            }else if(oprator.equals(Operator.NOTLIKE)){
                //用SQL限定查询 
                criterion = Restrictions.sqlRestriction(fieldName+"   not like '" + value + "' ");
            } else {
                throw new ViewException("operator不符合查询标识符规则 ");
            }   
            return criterion;
        } else {
            return criterion;
        }
    }

	private static Criterion getMultiLike(String fieldName, Object value) {
		Criterion criterion = null;
		if(!StringUtil.isEmpty(value.toString())) {
			String[] values = value.toString().split(",");
			for(int i=0; i< values.length; i++) {
				Criterion createCriterion = Restrictions.like(fieldName, "%"+values[i]+"%");
				if (i == 0) {
                    criterion = createCriterion;
                } else {
                	criterion = Restrictions.or(criterion, createCriterion);
                }
			}
		}
		return criterion;
	}
}

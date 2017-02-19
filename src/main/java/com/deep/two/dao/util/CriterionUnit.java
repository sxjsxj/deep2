package com.deep.two.dao.util;

/**
 * ClassName: CriterionUnit <br/>
 * Description: 封装查询条件 key value以及查询条件的标识符号operator <br/>
 * Date: 2014-7-14 上午10:29:45 <br/>
 * 
 * @author ggf(ggfjava@sina.cn) 修改记录
 * @version 产品版本信息 2014-07-14 ggf(ggfjava@sina.cn) 修改信息<br/>
 * 
 */
public class CriterionUnit {

    private Object value;
    private String key;
    /**
     * operator: 标识 > = <
     */
    private String operator;

    /**
     * Creates a new instance of CriterionUnit.<br/>
     * Description: 构造器 <br/>
     */
    public CriterionUnit() {

    }

    /**
     * Creates a new instance of CriterionUnit.<br/>
     * 
     * @param key
     *            orm中的属性名称
     * @param value
     *            orm中的属性的值
     */
    public CriterionUnit(String key, Object value) {
        this.value = value;
        this.key = key;
        this.operator = Operator.EQ;
    }

    /**
     * 
     * Creates a new instance of CriterionUnit.<br/>
     * 
     * @param key
     *            orm中的属性名称
     * @param operator
     *            查询条件符号
     * @param value
     *            orm中的属性的值
     */
    public CriterionUnit(String key, String operator, Object value) {

        this.key = key;
        this.value = value;
        this.operator = operator;
    }

    /**
     * getValue: getter方法 <br/>
     * 
     * @return value <br/>
     */
    public Object getValue() {
        return value;
    }

    /**
     * setValue: setter方法 <br/>
     * 
     * @param value
     *            值<br/>
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * getKey: getter方法 <br/>
     * 
     * @return key <br/>
     */
    public String getKey() {
        return key;
    }

    /**
     * setKey: setter方法 <br/>
     * 
     * @param key
     *            键<br/>
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * getOperator: getter方法 <br/>
     * 
     * @return operator <br/>
     */
    public String getOperator() {
        return operator;
    }

    /**
     * setOperator:setter方法 <br/>
     * 
     * @param operator
     *            操作符 <br/>
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "CriterionUnit [value=" + value + ", key=" + key + ", operator=" + operator + "]";
    }

}

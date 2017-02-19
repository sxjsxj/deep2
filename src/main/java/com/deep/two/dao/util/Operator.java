package com.deep.two.dao.util;

/**
 * 
 * ClassName: Operator <br/>
 * Description: CriterionUtil类里创建Criterion常量值 <br/>
 * Date: 2014-7-14 下午3:09:35 <br/>
 * 
 * @author ggf(ggfjava@sina.cn) 修改记录
 * @version 产品版本信息 2014-07-14 ggf(ggfjava@sina.cn) 修改信息<br/>
 * 
 */
public final class Operator {

    public static final String GT = ">";
    public static final String LT = "<";
    public static final String EQ = "=";
    public static final String NE = "<>";
    public static final String GE = ">=";
    public static final String LE = "<=";
    public static final String LK = "like";
    
    public static final String IN = "in";
    public static final String NN = "nn";

    public static final String NOTLIKE = "notlike";

    public static final String ISNULL = "isNULL";
    public static final String ISNOTNULL = "isNotNULL";

    public static final String AD = "and";
    public static final String OR = "or";

    public static final String GT_PROPERTY = ">PROPERTY";
    public static final String LT_PROPERTY = "<PROPERTY";
    public static final String EQ_PROPERTY = "=PROPERTY";
    public static final String NE_PROPERTY = "<>PROPERTY";
    public static final String GE_PROPERTY = ">=PROPERTY";
    public static final String LE_PROPERTY = "<=PROPERTY";
    
    public static final String IGNORE = "IGNORE";
	public static final String MULTILK = "multiLike";

    /**
     * Creates a new instance of Operator.<br/>
     * Description: 私有构造器<br/>
     */
    private Operator() {

    }

}

package com.kangyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuiJiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuiJiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGuijiIdIsNull() {
            addCriterion("guiji_id is null");
            return (Criteria) this;
        }

        public Criteria andGuijiIdIsNotNull() {
            addCriterion("guiji_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuijiIdEqualTo(Long value) {
            addCriterion("guiji_id =", value, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdNotEqualTo(Long value) {
            addCriterion("guiji_id <>", value, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdGreaterThan(Long value) {
            addCriterion("guiji_id >", value, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdGreaterThanOrEqualTo(Long value) {
            addCriterion("guiji_id >=", value, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdLessThan(Long value) {
            addCriterion("guiji_id <", value, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdLessThanOrEqualTo(Long value) {
            addCriterion("guiji_id <=", value, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdIn(List<Long> values) {
            addCriterion("guiji_id in", values, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdNotIn(List<Long> values) {
            addCriterion("guiji_id not in", values, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdBetween(Long value1, Long value2) {
            addCriterion("guiji_id between", value1, value2, "guijiId");
            return (Criteria) this;
        }

        public Criteria andGuijiIdNotBetween(Long value1, Long value2) {
            addCriterion("guiji_id not between", value1, value2, "guijiId");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andJinduIsNull() {
            addCriterion("jindu is null");
            return (Criteria) this;
        }

        public Criteria andJinduIsNotNull() {
            addCriterion("jindu is not null");
            return (Criteria) this;
        }

        public Criteria andJinduEqualTo(BigDecimal value) {
            addCriterion("jindu =", value, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduNotEqualTo(BigDecimal value) {
            addCriterion("jindu <>", value, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduGreaterThan(BigDecimal value) {
            addCriterion("jindu >", value, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jindu >=", value, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduLessThan(BigDecimal value) {
            addCriterion("jindu <", value, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jindu <=", value, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduIn(List<BigDecimal> values) {
            addCriterion("jindu in", values, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduNotIn(List<BigDecimal> values) {
            addCriterion("jindu not in", values, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jindu between", value1, value2, "jindu");
            return (Criteria) this;
        }

        public Criteria andJinduNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jindu not between", value1, value2, "jindu");
            return (Criteria) this;
        }

        public Criteria andWeiduIsNull() {
            addCriterion("weidu is null");
            return (Criteria) this;
        }

        public Criteria andWeiduIsNotNull() {
            addCriterion("weidu is not null");
            return (Criteria) this;
        }

        public Criteria andWeiduEqualTo(BigDecimal value) {
            addCriterion("weidu =", value, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduNotEqualTo(BigDecimal value) {
            addCriterion("weidu <>", value, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduGreaterThan(BigDecimal value) {
            addCriterion("weidu >", value, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weidu >=", value, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduLessThan(BigDecimal value) {
            addCriterion("weidu <", value, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weidu <=", value, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduIn(List<BigDecimal> values) {
            addCriterion("weidu in", values, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduNotIn(List<BigDecimal> values) {
            addCriterion("weidu not in", values, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weidu between", value1, value2, "weidu");
            return (Criteria) this;
        }

        public Criteria andWeiduNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weidu not between", value1, value2, "weidu");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionIsNull() {
            addCriterion("guiji_position is null");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionIsNotNull() {
            addCriterion("guiji_position is not null");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionEqualTo(String value) {
            addCriterion("guiji_position =", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionNotEqualTo(String value) {
            addCriterion("guiji_position <>", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionGreaterThan(String value) {
            addCriterion("guiji_position >", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionGreaterThanOrEqualTo(String value) {
            addCriterion("guiji_position >=", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionLessThan(String value) {
            addCriterion("guiji_position <", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionLessThanOrEqualTo(String value) {
            addCriterion("guiji_position <=", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionLike(String value) {
            addCriterion("guiji_position like", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionNotLike(String value) {
            addCriterion("guiji_position not like", value, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionIn(List<String> values) {
            addCriterion("guiji_position in", values, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionNotIn(List<String> values) {
            addCriterion("guiji_position not in", values, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionBetween(String value1, String value2) {
            addCriterion("guiji_position between", value1, value2, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andGuijiPositionNotBetween(String value1, String value2) {
            addCriterion("guiji_position not between", value1, value2, "guijiPosition");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
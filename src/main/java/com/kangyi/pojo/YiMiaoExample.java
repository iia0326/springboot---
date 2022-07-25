package com.kangyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YiMiaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YiMiaoExample() {
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

        public Criteria andYimiaoIdIsNull() {
            addCriterion("yimiao_id is null");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdIsNotNull() {
            addCriterion("yimiao_id is not null");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdEqualTo(Long value) {
            addCriterion("yimiao_id =", value, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdNotEqualTo(Long value) {
            addCriterion("yimiao_id <>", value, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdGreaterThan(Long value) {
            addCriterion("yimiao_id >", value, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("yimiao_id >=", value, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdLessThan(Long value) {
            addCriterion("yimiao_id <", value, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdLessThanOrEqualTo(Long value) {
            addCriterion("yimiao_id <=", value, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdIn(List<Long> values) {
            addCriterion("yimiao_id in", values, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdNotIn(List<Long> values) {
            addCriterion("yimiao_id not in", values, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdBetween(Long value1, Long value2) {
            addCriterion("yimiao_id between", value1, value2, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimiaoIdNotBetween(Long value1, Long value2) {
            addCriterion("yimiao_id not between", value1, value2, "yimiaoId");
            return (Criteria) this;
        }

        public Criteria andYimaioNameIsNull() {
            addCriterion("yimaio_name is null");
            return (Criteria) this;
        }

        public Criteria andYimaioNameIsNotNull() {
            addCriterion("yimaio_name is not null");
            return (Criteria) this;
        }

        public Criteria andYimaioNameEqualTo(String value) {
            addCriterion("yimaio_name =", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameNotEqualTo(String value) {
            addCriterion("yimaio_name <>", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameGreaterThan(String value) {
            addCriterion("yimaio_name >", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameGreaterThanOrEqualTo(String value) {
            addCriterion("yimaio_name >=", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameLessThan(String value) {
            addCriterion("yimaio_name <", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameLessThanOrEqualTo(String value) {
            addCriterion("yimaio_name <=", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameLike(String value) {
            addCriterion("yimaio_name like", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameNotLike(String value) {
            addCriterion("yimaio_name not like", value, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameIn(List<String> values) {
            addCriterion("yimaio_name in", values, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameNotIn(List<String> values) {
            addCriterion("yimaio_name not in", values, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameBetween(String value1, String value2) {
            addCriterion("yimaio_name between", value1, value2, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimaioNameNotBetween(String value1, String value2) {
            addCriterion("yimaio_name not between", value1, value2, "yimaioName");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionIsNull() {
            addCriterion("yimiao_position is null");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionIsNotNull() {
            addCriterion("yimiao_position is not null");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionEqualTo(String value) {
            addCriterion("yimiao_position =", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionNotEqualTo(String value) {
            addCriterion("yimiao_position <>", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionGreaterThan(String value) {
            addCriterion("yimiao_position >", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionGreaterThanOrEqualTo(String value) {
            addCriterion("yimiao_position >=", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionLessThan(String value) {
            addCriterion("yimiao_position <", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionLessThanOrEqualTo(String value) {
            addCriterion("yimiao_position <=", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionLike(String value) {
            addCriterion("yimiao_position like", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionNotLike(String value) {
            addCriterion("yimiao_position not like", value, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionIn(List<String> values) {
            addCriterion("yimiao_position in", values, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionNotIn(List<String> values) {
            addCriterion("yimiao_position not in", values, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionBetween(String value1, String value2) {
            addCriterion("yimiao_position between", value1, value2, "yimiaoPosition");
            return (Criteria) this;
        }

        public Criteria andYimiaoPositionNotBetween(String value1, String value2) {
            addCriterion("yimiao_position not between", value1, value2, "yimiaoPosition");
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

        public Criteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterion("startdate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterion("startdate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterion("startdate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("startdate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterion("startdate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterion("startdate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterion("startdate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterion("startdate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterion("startdate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterion("startdate not between", value1, value2, "startdate");
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

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("starttime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("starttime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
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

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endtime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endtime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("org_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("org_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("org_type =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("org_type <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("org_type >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("org_type >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("org_type <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("org_type <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("org_type like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("org_type not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("org_type in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("org_type not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("org_type between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("org_type not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andRenshuIsNull() {
            addCriterion("renshu is null");
            return (Criteria) this;
        }

        public Criteria andRenshuIsNotNull() {
            addCriterion("renshu is not null");
            return (Criteria) this;
        }

        public Criteria andRenshuEqualTo(String value) {
            addCriterion("renshu =", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuNotEqualTo(String value) {
            addCriterion("renshu <>", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuGreaterThan(String value) {
            addCriterion("renshu >", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuGreaterThanOrEqualTo(String value) {
            addCriterion("renshu >=", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuLessThan(String value) {
            addCriterion("renshu <", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuLessThanOrEqualTo(String value) {
            addCriterion("renshu <=", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuLike(String value) {
            addCriterion("renshu like", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuNotLike(String value) {
            addCriterion("renshu not like", value, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuIn(List<String> values) {
            addCriterion("renshu in", values, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuNotIn(List<String> values) {
            addCriterion("renshu not in", values, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuBetween(String value1, String value2) {
            addCriterion("renshu between", value1, value2, "renshu");
            return (Criteria) this;
        }

        public Criteria andRenshuNotBetween(String value1, String value2) {
            addCriterion("renshu not between", value1, value2, "renshu");
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
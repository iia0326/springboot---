package com.kangyi.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeLiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GeLiExample() {
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

        public Criteria andGeliIdIsNull() {
            addCriterion("geli_id is null");
            return (Criteria) this;
        }

        public Criteria andGeliIdIsNotNull() {
            addCriterion("geli_id is not null");
            return (Criteria) this;
        }

        public Criteria andGeliIdEqualTo(Long value) {
            addCriterion("geli_id =", value, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdNotEqualTo(Long value) {
            addCriterion("geli_id <>", value, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdGreaterThan(Long value) {
            addCriterion("geli_id >", value, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdGreaterThanOrEqualTo(Long value) {
            addCriterion("geli_id >=", value, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdLessThan(Long value) {
            addCriterion("geli_id <", value, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdLessThanOrEqualTo(Long value) {
            addCriterion("geli_id <=", value, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdIn(List<Long> values) {
            addCriterion("geli_id in", values, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdNotIn(List<Long> values) {
            addCriterion("geli_id not in", values, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdBetween(Long value1, Long value2) {
            addCriterion("geli_id between", value1, value2, "geliId");
            return (Criteria) this;
        }

        public Criteria andGeliIdNotBetween(Long value1, Long value2) {
            addCriterion("geli_id not between", value1, value2, "geliId");
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

        public Criteria andGelidianNameIsNull() {
            addCriterion("gelidian_name is null");
            return (Criteria) this;
        }

        public Criteria andGelidianNameIsNotNull() {
            addCriterion("gelidian_name is not null");
            return (Criteria) this;
        }

        public Criteria andGelidianNameEqualTo(String value) {
            addCriterion("gelidian_name =", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameNotEqualTo(String value) {
            addCriterion("gelidian_name <>", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameGreaterThan(String value) {
            addCriterion("gelidian_name >", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameGreaterThanOrEqualTo(String value) {
            addCriterion("gelidian_name >=", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameLessThan(String value) {
            addCriterion("gelidian_name <", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameLessThanOrEqualTo(String value) {
            addCriterion("gelidian_name <=", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameLike(String value) {
            addCriterion("gelidian_name like", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameNotLike(String value) {
            addCriterion("gelidian_name not like", value, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameIn(List<String> values) {
            addCriterion("gelidian_name in", values, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameNotIn(List<String> values) {
            addCriterion("gelidian_name not in", values, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameBetween(String value1, String value2) {
            addCriterion("gelidian_name between", value1, value2, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianNameNotBetween(String value1, String value2) {
            addCriterion("gelidian_name not between", value1, value2, "gelidianName");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionIsNull() {
            addCriterion("gelidian_position is null");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionIsNotNull() {
            addCriterion("gelidian_position is not null");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionEqualTo(String value) {
            addCriterion("gelidian_position =", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionNotEqualTo(String value) {
            addCriterion("gelidian_position <>", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionGreaterThan(String value) {
            addCriterion("gelidian_position >", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionGreaterThanOrEqualTo(String value) {
            addCriterion("gelidian_position >=", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionLessThan(String value) {
            addCriterion("gelidian_position <", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionLessThanOrEqualTo(String value) {
            addCriterion("gelidian_position <=", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionLike(String value) {
            addCriterion("gelidian_position like", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionNotLike(String value) {
            addCriterion("gelidian_position not like", value, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionIn(List<String> values) {
            addCriterion("gelidian_position in", values, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionNotIn(List<String> values) {
            addCriterion("gelidian_position not in", values, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionBetween(String value1, String value2) {
            addCriterion("gelidian_position between", value1, value2, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGelidianPositionNotBetween(String value1, String value2) {
            addCriterion("gelidian_position not between", value1, value2, "gelidianPosition");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuIsNull() {
            addCriterion("grlirenshu is null");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuIsNotNull() {
            addCriterion("grlirenshu is not null");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuEqualTo(Integer value) {
            addCriterion("grlirenshu =", value, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuNotEqualTo(Integer value) {
            addCriterion("grlirenshu <>", value, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuGreaterThan(Integer value) {
            addCriterion("grlirenshu >", value, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuGreaterThanOrEqualTo(Integer value) {
            addCriterion("grlirenshu >=", value, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuLessThan(Integer value) {
            addCriterion("grlirenshu <", value, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuLessThanOrEqualTo(Integer value) {
            addCriterion("grlirenshu <=", value, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuIn(List<Integer> values) {
            addCriterion("grlirenshu in", values, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuNotIn(List<Integer> values) {
            addCriterion("grlirenshu not in", values, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuBetween(Integer value1, Integer value2) {
            addCriterion("grlirenshu between", value1, value2, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andGrlirenshuNotBetween(Integer value1, Integer value2) {
            addCriterion("grlirenshu not between", value1, value2, "grlirenshu");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andGeliOrgIsNull() {
            addCriterion("geli_org is null");
            return (Criteria) this;
        }

        public Criteria andGeliOrgIsNotNull() {
            addCriterion("geli_org is not null");
            return (Criteria) this;
        }

        public Criteria andGeliOrgEqualTo(String value) {
            addCriterion("geli_org =", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgNotEqualTo(String value) {
            addCriterion("geli_org <>", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgGreaterThan(String value) {
            addCriterion("geli_org >", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgGreaterThanOrEqualTo(String value) {
            addCriterion("geli_org >=", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgLessThan(String value) {
            addCriterion("geli_org <", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgLessThanOrEqualTo(String value) {
            addCriterion("geli_org <=", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgLike(String value) {
            addCriterion("geli_org like", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgNotLike(String value) {
            addCriterion("geli_org not like", value, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgIn(List<String> values) {
            addCriterion("geli_org in", values, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgNotIn(List<String> values) {
            addCriterion("geli_org not in", values, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgBetween(String value1, String value2) {
            addCriterion("geli_org between", value1, value2, "geliOrg");
            return (Criteria) this;
        }

        public Criteria andGeliOrgNotBetween(String value1, String value2) {
            addCriterion("geli_org not between", value1, value2, "geliOrg");
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